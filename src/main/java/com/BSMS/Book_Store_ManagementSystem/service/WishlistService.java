package com.BSMS.Book_Store_ManagementSystem.service;

import com.BSMS.Book_Store_ManagementSystem.model.Wishlist;
import com.BSMS.Book_Store_ManagementSystem.model.WishlistItem;

import java.util.List;

public interface WishlistService {
     Wishlist AddproducttoWishlist(Long user_id, Long product_id);
     void removeWishlistItem(long id);

     List<WishlistItem> findAllWishlistItems();
}
