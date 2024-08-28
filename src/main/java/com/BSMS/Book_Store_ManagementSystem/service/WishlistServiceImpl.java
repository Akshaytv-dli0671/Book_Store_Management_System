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

import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

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

        // Save the wishlist first
        wishlist = wishlistRepository.save(wishlist);

        WishlistItem wishlistItem = new WishlistItem();
        wishlistItem.setProduct(product);
        wishlistItem.setWishlist(wishlist);

        // Save the wishlist item
        wishlistItemRepository.save(wishlistItem);

        wishlist.getItems().add(wishlistItem);

        // Save the wishlist again to update the items list
        wishlistRepository.save(wishlist);

        return wishlist;
    }


    @Autowired
    private WishlistItemRepository wishlistItemsRepository;

    @Override
    public void removeWishlistItem(long id) {
        wishlistItemsRepository.deleteById(id);
    }

    public List<WishlistItem> findAllWishlistItems() {
        return wishlistItemsRepository.findAll();
    }
    }

