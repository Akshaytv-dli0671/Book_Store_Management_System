package com.BSMS.Book_Store_ManagementSystem.repository;

import com.BSMS.Book_Store_ManagementSystem.model.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WishlistItemRepository extends JpaRepository<WishlistItem, Long> {

}
