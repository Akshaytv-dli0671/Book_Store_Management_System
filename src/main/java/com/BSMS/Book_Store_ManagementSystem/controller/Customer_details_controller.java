package com.BSMS.Book_Store_ManagementSystem.controller;
import com.BSMS.Book_Store_ManagementSystem.model.Customer_Details;
import com.BSMS.Book_Store_ManagementSystem.service.Customer_details_Service;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bookstore_user")
public class Customer_details_controller {
    @Autowired
    Customer_details_Service customerDetailsService;

    @PostMapping("/add-customer_details")
    public ResponseEntity<Customer_Details> addCustomerDetails(@Valid  @RequestBody Customer_Details customerDetails) {
        Customer_Details createdCustomerDetails = customerDetailsService.addCustomerDetails(customerDetails);
        return ResponseEntity.ok(createdCustomerDetails);
    }

    @PutMapping ("/edit_user")
    public ResponseEntity<Customer_Details> updateCustomerDetails(@RequestBody Customer_Details customerDetails) {
        try {
            Customer_Details updatedCustomerDetails = customerDetailsService.updateCustomerDetails(customerDetails);
            return ResponseEntity.ok(updatedCustomerDetails);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

}
