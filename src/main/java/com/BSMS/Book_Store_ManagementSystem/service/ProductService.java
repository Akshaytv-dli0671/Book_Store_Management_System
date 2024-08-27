
package com.BSMS.Book_Store_ManagementSystem.service;

import com.BSMS.Book_Store_ManagementSystem.model.Products;
import com.BSMS.Book_Store_ManagementSystem.repository.ProductRepository;
import org.hibernate.mapping.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.sql.Timestamp;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public Products addProduct(Products products) {
        Timestamp currentTimeStamp = new Timestamp(System.currentTimeMillis());
        products.setCreatedAt(currentTimeStamp);
        products.setUpdatedAt(currentTimeStamp);
        return productRepository.save(products);
    }

    public Products updateProduct(Long id, Products updatedProduct) {
        Optional<Products> optionalProducts = productRepository.findById(id);
        if (optionalProducts.isPresent()) {
            Products existingProduct = optionalProducts.get();
            existingProduct.setProductName(updatedProduct.getProductName());
            existingProduct.setProductDescription(updatedProduct.getProductDescription());
            existingProduct.setProductPrice(updatedProduct.getProductPrice());
            existingProduct.setStock(updatedProduct.getStock());
            existingProduct.setProductAuthor(updatedProduct.getProductAuthor());
            existingProduct.setProductCategory(updatedProduct.getProductCategory());
            existingProduct.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
            return productRepository.save(existingProduct);

        } else {
            throw new RuntimeException("Product Not Found");
        }
    }

    public Optional<Products> getProductBydId(Long id) {
        return productRepository.findById(id);
    }
}