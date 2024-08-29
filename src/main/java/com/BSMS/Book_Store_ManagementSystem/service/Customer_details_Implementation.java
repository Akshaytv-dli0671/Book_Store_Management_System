package com.BSMS.Book_Store_ManagementSystem.service;

import com.BSMS.Book_Store_ManagementSystem.exception.CustomException;
import com.BSMS.Book_Store_ManagementSystem.model.Customer_Details;
import com.BSMS.Book_Store_ManagementSystem.model.User;
import com.BSMS.Book_Store_ManagementSystem.repository.CustomerDetailsRepository;
import com.BSMS.Book_Store_ManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Customer_details_Implementation implements Customer_details_Service{
    @Autowired
    CustomerDetailsRepository customerDetailsRepository;
    @Autowired
    UserRepository userRepository;

    @Override
    public Customer_Details addCustomerDetails(Customer_Details customerDetails) {
        long userId=customerDetails.getUser().getUser_id();
        Customer_Details customer_details=customerDetailsRepository.findbyUserID(userId);
        if(customer_details==null){
            return customerDetailsRepository.save(customerDetails);
        }
        else{
            throw new CustomException("Customer details already saved! You can update the current details.");
        }

    }

    @Override
    public Customer_Details updateCustomerDetails(Customer_Details customerDetails) {
        long id=customerDetails.getUser().getUser_id();
        Customer_Details existingDetails=customerDetailsRepository.findbyUserID(id);
        if(existingDetails!=null){
            existingDetails.setAddress(customerDetails.getAddress());
            existingDetails.setName(customerDetails.getName());
            existingDetails.setEmail(customerDetails.getEmail());
            existingDetails.setPhoneNumber(customerDetails.getPhoneNumber());
            return customerDetailsRepository.save(existingDetails);
        }
        else{
            throw new CustomException("Customer not found with id " + id);
        }
    }



}
