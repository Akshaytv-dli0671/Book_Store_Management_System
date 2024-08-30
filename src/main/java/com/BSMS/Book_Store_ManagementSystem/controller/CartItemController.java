package com.BSMS.Book_Store_ManagementSystem.controller;

import com.BSMS.Book_Store_ManagementSystem.model.Cart;
import com.BSMS.Book_Store_ManagementSystem.model.CartItem;
import com.BSMS.Book_Store_ManagementSystem.service.CartItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookstore_user")
public class CartItemController {
    @Autowired
    CartItemService cartItemService;


    @PostMapping("/add_cart_item/{id}")
    public ResponseEntity<String> addCartItem(@PathVariable("id") Long product_id,@RequestBody Long userid) {
        return cartItemService.addCartItem(product_id,userid);
    }
    @PutMapping("/cartItem_quantity/{cart_itemId}")
    public ResponseEntity<String> updateCartItemQuantity(@PathVariable Long cart_itemId, @RequestParam int quantity) {
        return cartItemService.updateCartItemQuantity(cart_itemId, quantity);
    }

    @DeleteMapping("/remove_cartItem/{cart_itemId}")
    public ResponseEntity<String> removeCartItem(@PathVariable Long cart_itemId) {
        return cartItemService.removeCartItem(cart_itemId);
    }
    @GetMapping("/getcartItems")
    public ResponseEntity<List<CartItem>> getCartItems() {
        return cartItemService.getCartItems();
    }

}
