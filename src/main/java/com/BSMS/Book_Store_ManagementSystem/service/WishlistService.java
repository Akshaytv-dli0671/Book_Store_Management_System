package com.BSMS.Book_Store_ManagementSystem.service;

import com.BSMS.Book_Store_ManagementSystem.model.Wishlist;
import com.BSMS.Book_Store_ManagementSystem.model.WishlistItem;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface WishlistService {
     Wishlist AddproducttoWishlist(Long user_id, Long id);
     void removeWishlistItem(long id);

     List<WishlistItem> findAllWishlistItems();
}
