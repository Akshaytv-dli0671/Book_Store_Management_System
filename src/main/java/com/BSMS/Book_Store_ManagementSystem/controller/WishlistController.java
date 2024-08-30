package com.BSMS.Book_Store_ManagementSystem.controller;

import com.BSMS.Book_Store_ManagementSystem.model.Products;
import com.BSMS.Book_Store_ManagementSystem.model.Wishlist;
import com.BSMS.Book_Store_ManagementSystem.model.WishlistItem;
import com.BSMS.Book_Store_ManagementSystem.repository.WishlistRepository;
import com.BSMS.Book_Store_ManagementSystem.service.WishlistService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bookstore_user")
public class WishlistController {
    @Autowired
    private WishlistService wishlistService;


    @PostMapping("/add_wish_list")
    public ResponseEntity<Wishlist> AddproducttoWishlist(@RequestParam Long user_id, @RequestParam Long id) {
        Wishlist wishlist = wishlistService.AddproducttoWishlist(user_id, id);
        return ResponseEntity.ok(wishlist);
    }
    @Autowired
    private WishlistService wishlistItemsService;

    @DeleteMapping("/remove_wishlist_item/{wishlistId}")
    public ResponseEntity<String> removeWishlistItem(@PathVariable("wishlistId") Long wishlistItemId) {
        if (wishlistItemsService.findWishlistItemById(wishlistItemId)==null) {
            return new ResponseEntity<>("Wishlist item not found", HttpStatus.NOT_FOUND);
        }else {
        wishlistItemsService.removeWishlistItem(wishlistItemId);
        return new ResponseEntity<>("Wishlist item removed successfully", HttpStatus.OK);
        }
    }

    @GetMapping("/get_wishlist_items")
    public ResponseEntity<List<WishlistItem>> findAllWishlistItems() {
        return new ResponseEntity<>(wishlistItemsService.findAllWishlistItems(), HttpStatus.OK);
    }

    @GetMapping("/get_wishlist_items/{userId}")
    public ResponseEntity<Optional<Wishlist>> getWishlistItemsByUserId(@PathVariable("userId") Long userId) {
        Optional<Wishlist> wishlist = wishlistService.findWishlistItemsByUserId(userId);
        if (wishlist.isPresent()) {
            return ResponseEntity.ok(wishlist);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
