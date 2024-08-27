package com.BSMS.Book_Store_ManagementSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NonNull;

import java.sql.Timestamp;

@Data
@Entity
@Table(name="products_table")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull
    private String productName;

    private String productDescription;

    private double productPrice;

    @NotNull
    private String productAuthor;

    @NotNull
    private int stock;

    private String productCategory;

    private Timestamp createdAt;

    private Timestamp updatedAt;

}
