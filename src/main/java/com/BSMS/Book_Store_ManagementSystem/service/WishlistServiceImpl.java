package com.BSMS.Book_Store_ManagementSystem.service;

import com.BSMS.Book_Store_ManagementSystem.exception.ProductNotFoundException;
import com.BSMS.Book_Store_ManagementSystem.model.Products;
import com.BSMS.Book_Store_ManagementSystem.model.User;
import com.BSMS.Book_Store_ManagementSystem.model.Wishlist;
import com.BSMS.Book_Store_ManagementSystem.model.WishlistItem;
import com.BSMS.Book_Store_ManagementSystem.repository.ProductRepository;
import com.BSMS.Book_Store_ManagementSystem.repository.UserRepository;
import com.BSMS.Book_Store_ManagementSystem.repository.WishlistItemRepository;
import com.BSMS.Book_Store_ManagementSystem.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class WishlistServiceImpl implements WishlistService {

    @Autowired
    private WishlistRepository wishlistRepository;

    @Autowired
    private WishlistItemRepository wishlistItemRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private UserRepository userRepository;
    @Override
    public Wishlist AddproducttoWishlist(Long user_id, Long id) {
        Wishlist wishlist = wishlistRepository.findByUserId(user_id)
                .orElseGet(() -> {
                    Wishlist newWishlist = new Wishlist();
                    newWishlist.setCreatedAt(Timestamp.valueOf(LocalDateTime.now()));
                    return newWishlist;
                });

        Products product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        User user = userRepository.findById(user_id)
                .orElseThrow(() -> new ProductNotFoundException("User not found"));

        wishlist.setUser(user);
        wishlist = wishlistRepository.save(wishlist);
        boolean productExists = wishlist.getItems().stream()
                .anyMatch(item -> item.getProduct().getId().equals(id));

        if (productExists) {
            throw new ProductNotFoundException("Product already in wishlist");
        }

        WishlistItem wishlistItem = new WishlistItem();
        wishlistItem.setProduct(product);
        wishlistItem.setWishlist(wishlist);
        wishlistItemRepository.save(wishlistItem);
        wishlist.getItems().add(wishlistItem);
        wishlistRepository.save(wishlist);

        return wishlist;
    }



    @Autowired
    private WishlistItemRepository wishlistItemsRepository;


    @Override
    public void removeWishlistItem(long wishlistItemId) {
        wishlistItemsRepository.deleteById(wishlistItemId);
    }

    public List<WishlistItem> findAllWishlistItems() {
        return wishlistItemsRepository.findAll();
    }

    @Override
    public Optional<Wishlist> findWishlistItemsByUserId(Long userId) {
        return wishlistRepository.findByUserId(userId);
    }

    @Override
    public WishlistItem findWishlistItemById(Long wishlistItemId) {
        return wishlistItemsRepository.findByWishlistItemId(wishlistItemId);
    }



}

