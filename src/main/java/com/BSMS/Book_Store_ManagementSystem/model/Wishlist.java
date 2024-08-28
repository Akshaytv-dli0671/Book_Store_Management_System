package com.BSMS.Book_Store_ManagementSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "wishlist_table")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Wishlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Wishlist Id is required")
    private Long wishlistId;

    @NotNull(message = "createdtme is required")
    private Timestamp createdAt;

    @OneToOne
    @JoinColumn(name = "user_id")
    @NotNull(message = "User is required")
    private User user;

    @OneToMany(mappedBy = "wishlist", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<WishlistItem> items = new ArrayList<>();


}
