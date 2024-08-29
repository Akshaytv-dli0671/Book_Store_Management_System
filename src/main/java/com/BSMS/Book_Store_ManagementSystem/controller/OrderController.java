package com.BSMS.Book_Store_ManagementSystem.controller;

import com.BSMS.Book_Store_ManagementSystem.model.Order;
import com.BSMS.Book_Store_ManagementSystem.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bookstore_user")
public class OrderController {
    @Autowired
    OrderService orderService;
    @PostMapping("/add/order")
    public Order placeOrder(@RequestBody Long userId) {
        return orderService.placeOrder(userId);
    }
}
