package com.BSMS.Book_Store_ManagementSystem.repository;

import com.BSMS.Book_Store_ManagementSystem.model.WishlistItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WishlistItemRepository extends JpaRepository<WishlistItem, Long> {

}
