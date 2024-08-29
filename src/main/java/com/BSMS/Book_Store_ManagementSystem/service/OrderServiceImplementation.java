package com.BSMS.Book_Store_ManagementSystem.service;

import com.BSMS.Book_Store_ManagementSystem.model.*;
import com.BSMS.Book_Store_ManagementSystem.repository.*;
import jakarta.persistence.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class OrderServiceImplementation implements  OrderService{
    @Autowired
    CartRepository cartRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CartItemRepository cartItemRepository;
    @Autowired
    OrderItemRepository orderItemRepository;

    @Transactional
    @Override
    public Order placeOrder(Long userId) {
            User user = userRepository.findById(userId).orElse(null);
            Cart cart = cartRepository.findByUserId(userId);

            if (user == null || cart == null) {
                throw new IllegalArgumentException("User or Cart not found");
            }

            Order order = new Order();
            order.setUser(user);
            List<OrderItem> orderItems = new ArrayList<>();

            for (CartItem cartItem : cart.getCartItems()) {
                OrderItem orderItem = new OrderItem();
                Products product = cartItem.getProduct();
                orderItem.setProduct(product);
                orderItem.setQuantity(cartItem.getQuantity());
                product.setStock(product.getStock()- cartItem.getQuantity());
                orderItem.setPrice(BigDecimal.valueOf(product.getProductPrice()));
                orderItems.add(orderItem);
                cartItemRepository.delete(cartItem);
                cartItemRepository.flush();
            }

            BigDecimal totalAmount = BigDecimal.ZERO;
            for (OrderItem item : orderItems) {
                totalAmount = totalAmount.add(item.getPrice().multiply(BigDecimal.valueOf(item.getQuantity())));
            }

            order.setTotalAmount(totalAmount);
            order.setOrderStatus(OrderStatus.PENDING);
            order.setCreatedAt(new Timestamp(System.currentTimeMillis()));

            order = orderRepository.save(order);

            for (OrderItem orderItem : orderItems) {
                orderItem.setOrder(order);
                orderItemRepository.save(orderItem);
            }

            order.setOrderItems(orderItems);
            order = orderRepository.save(order);


        cart.setCartItems(new ArrayList<>());
        cartRepository.save(cart);

        return order;
        }


}