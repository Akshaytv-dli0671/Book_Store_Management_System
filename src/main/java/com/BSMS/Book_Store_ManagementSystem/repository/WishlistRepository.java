package com.BSMS.Book_Store_ManagementSystem.repository;

import com.BSMS.Book_Store_ManagementSystem.model.Wishlist;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface WishlistRepository extends JpaRepository<Wishlist, Long> {

    Optional<Wishlist> findByUserId(Long user_id);

}
