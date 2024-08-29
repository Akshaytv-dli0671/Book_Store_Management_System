package com.BSMS.Book_Store_ManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
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
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "wishlistItemId")
public class WishlistItem {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long wishlistItemId;


    @ManyToOne
    @JoinColumn(name = "wishlistId")
    @NotNull(message = "Wishlist is required")
    private Wishlist wishlist;

    @ManyToOne
    @JoinColumn(name = "id")
    @NotNull(message = "Product is required")
    private Products product;
    @Override
    public String toString() {
        return "WishlistItem{" +
                "wishlistItemId=" + wishlistItemId +
                ", wishlist=" + wishlist +
                ", product=" + product +
                '}';
    }

}
