package com.BSMS.Book_Store_ManagementSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "wishlist_item_table")
@NoArgsConstructor
@AllArgsConstructor
public class WishlistItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotNull(message = "Wishlist Item Id is required")
    private Long wishlistItemId;


    @ManyToOne
    @JoinColumn(name = "wishlistId")
    @NotNull(message = "Wishlist is required")
    private Wishlist wishlist;

    @ManyToOne
    @JoinColumn(name = "id")
    @NotNull(message = "Product is required")
    private Products product;
}
