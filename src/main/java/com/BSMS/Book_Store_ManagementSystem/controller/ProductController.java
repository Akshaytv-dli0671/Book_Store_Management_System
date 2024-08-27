package com.BSMS.Book_Store_ManagementSystem.controller;

import com.BSMS.Book_Store_ManagementSystem.model.Products;
import com.BSMS.Book_Store_ManagementSystem.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("admin/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @PostMapping("/add")
    public Products addProduct(@RequestBody Products products){
        return productService.addProduct(products);
    }

    @GetMapping("/{id}")
    public Optional<Products> getProductById(@PathVariable Long id){
        return productService.getProductBydId(id);
    }

    @PutMapping("/update/{id}")
    public Products updateProduct(@PathVariable Long id,@RequestBody Products products){
        return productService.updateProduct(id,products);
    }

//    @GetMapping("/name/{name}")
//    public Optional<Products> getProductByName(@PathVariable String productName){
//        return productService.getProductByName(productName);
//    }

    @DeleteMapping("/delete/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProduct(id);
    }


}
