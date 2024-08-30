package com.BSMS.Book_Store_ManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

import java.sql.Timestamp;
import java.util.List;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name="products_table")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @NotNull
    private String productName;

    private String productDescription;

    private double productPrice;

//    @NotNull
    private String productAuthor;

//    @NotNull
    private int stock;

    private String productCategory;

    private Timestamp createdAt;

    private Timestamp updatedAt;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<CartItem> cartItem;

    @Override
    public String toString() {
        return "Products{" +
                "id=" + id +
                ", productName='" + productName + '\'' +
                ", productAuthor='" + productAuthor + '\'' +
                ", productPrice=" + productPrice +
                ", stock=" + stock +
                '}';
    }

}
