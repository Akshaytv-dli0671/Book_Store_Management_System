package com.BSMS.Book_Store_ManagementSystem.service;

import com.BSMS.Book_Store_ManagementSystem.exception.ProductNotFoundException;
import com.BSMS.Book_Store_ManagementSystem.model.Products;
import com.BSMS.Book_Store_ManagementSystem.model.Wishlist;
import com.BSMS.Book_Store_ManagementSystem.model.WishlistItem;
import com.BSMS.Book_Store_ManagementSystem.repository.ProductRepository;
import com.BSMS.Book_Store_ManagementSystem.repository.WishlistItemRepository;
import com.BSMS.Book_Store_ManagementSystem.repository.WishlistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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

    @Override
    public Wishlist AddproducttoWishlist(Long user_id, Long id) {
        Wishlist wishlist = wishlistRepository.findByUserId(user_id)
                .orElseGet(() -> new Wishlist());

        Products product = productRepository.findById(id)
                .orElseThrow(() -> new ProductNotFoundException("Product not found"));

        WishlistItem wishlistItem = new WishlistItem();
        wishlistItem.setProduct(product);
        wishlistItem.setWishlist(wishlist);

        wishlist.getItems().add(wishlistItem);
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

