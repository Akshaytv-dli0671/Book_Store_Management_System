package com.BSMS.Book_Store_ManagementSystem.controller;

import com.BSMS.Book_Store_ManagementSystem.exception.ProductNotFoundException;
import com.BSMS.Book_Store_ManagementSystem.model.Admin;
import com.BSMS.Book_Store_ManagementSystem.model.Products;
import com.BSMS.Book_Store_ManagementSystem.service.AdminService;
import com.BSMS.Book_Store_ManagementSystem.service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookstore_user/admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private ProductService productService;

    @PostMapping("/register")
    public ResponseEntity<String> registerAdmin(@RequestBody Admin admin) {
        adminService.registerAdmin(admin);
        return ResponseEntity.ok("Admin registered successfully");
    }

    @PostMapping("/login")
    public ResponseEntity<Object> loginAdmin(@RequestBody Admin admin) {
        boolean isAuthenticated = adminService.authenticateAdmin(admin.getAdminUsername(), admin.getAdminPassword());
        if (isAuthenticated) {
            String token = adminService.generateToken(admin.getAdminUsername());
            return new ResponseEntity<>("Login sucess , Token --> "+token, HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");
        }
    }


    @PostMapping("/add/book")
    public ResponseEntity<Products> addProduct(@Valid @RequestBody Products product) {
        return new ResponseEntity<>(productService.addProduct(product), HttpStatus.CREATED);
    }

    @PutMapping("/update/book/{product_id}")
    public ResponseEntity<Object> updateProduct(@PathVariable("product_id") long id,@RequestBody Products product) {
        if (productService.getAllProducts().stream().noneMatch(p -> p.getId() == id)) {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        } else {
            product.setId(id);
            productService.updateProduct(product);
            return new ResponseEntity<>("Updated Successfully", HttpStatus.OK);
        }
    }

    @DeleteMapping("/delete/book/{product_id}")
    public ResponseEntity<Object> deleteProduct(@PathVariable("product_id") long id) {
        if (productService.getAllProducts().stream().noneMatch(product -> product.getId() == id)) {
            throw new ProductNotFoundException("Product with id " + id + " not found");
        }else {
            productService.deleteProduct(id);
            return new ResponseEntity<>("Deleted Successfully",HttpStatus.NO_CONTENT);
        }
    }
}
