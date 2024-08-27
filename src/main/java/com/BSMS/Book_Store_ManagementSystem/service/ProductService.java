package com.BSMS.Book_Store_ManagementSystem.service;

import com.BSMS.Book_Store_ManagementSystem.model.Products;

import java.util.List;

public interface ProductService {
    public List<Products> getAllProducts();
    public Products addProduct(Products product);
    public Products updateProduct(Products product);
    public void deleteProduct(long id);
}
