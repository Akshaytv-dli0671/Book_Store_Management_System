package com.BSMS.Book_Store_ManagementSystem.controller;

import com.BSMS.Book_Store_ManagementSystem.model.Wishlist;
import com.BSMS.Book_Store_ManagementSystem.model.WishlistItem;
import com.BSMS.Book_Store_ManagementSystem.service.WishlistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bookstore_user")
public class WishlistController {
    @Autowired
    private WishlistService wishlistService;

    @PostMapping("/add_wish_list/{id}")
    public ResponseEntity<Wishlist> AddproducttoWishlist(@RequestParam Long user_id, @PathVariable Long id) {
        Wishlist wishlist = wishlistService.AddproducttoWishlist(user_id, id);
        return ResponseEntity.ok(wishlist);
    }
    @Autowired
    private WishlistService wishlistItemsService;

    @DeleteMapping("/remove_wishlist_item/{product_id}")
    public ResponseEntity<String> removeWishlistItem(@PathVariable Long id) {
        wishlistItemsService.removeWishlistItem(id);
        return new ResponseEntity<>("Wishlist item removed successfully", HttpStatus.OK);
    }

    @GetMapping("/get_wishlist_items")
    public ResponseEntity<List<WishlistItem>> findAllWishlistItems() {
        return new ResponseEntity<>(wishlistItemsService.findAllWishlistItems(), HttpStatus.OK);
    }
}
