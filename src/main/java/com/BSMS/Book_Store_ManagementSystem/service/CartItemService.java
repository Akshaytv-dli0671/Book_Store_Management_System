package com.BSMS.Book_Store_ManagementSystem.service;

import com.BSMS.Book_Store_ManagementSystem.model.Cart;
import com.BSMS.Book_Store_ManagementSystem.model.CartItem;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface CartItemService {
    ResponseEntity<String> addCartItem(Long productId,Long userid);
    ResponseEntity<String> updateCartItemQuantity(Long cartItemId, int quantity);
    ResponseEntity<String> removeCartItem(Long cartItemId);
    ResponseEntity<List<CartItem>> getCartItems();


}
