package com.BSMS.Book_Store_ManagementSystem.service;

import com.BSMS.Book_Store_ManagementSystem.exception.CustomException;
import com.BSMS.Book_Store_ManagementSystem.model.Customer_Details;
import com.BSMS.Book_Store_ManagementSystem.repository.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Customer_details_Implementation implements Customer_details_Service{
    @Autowired
    CustomerDetailsRepository customerDetailsRepository;

    @Override
    public Customer_Details addCustomerDetails(Customer_Details customerDetails) {
        return customerDetailsRepository.save(customerDetails);
    }

    @Override
    public Customer_Details updateCustomerDetails(Long id, Customer_Details customerDetails) {
        Customer_Details existingDetails=customerDetailsRepository.findById(id).orElse(null);
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

    @Override
    public boolean DeleteCustomerDetails(Long id) {
        Customer_Details customer_details=customerDetailsRepository.findById(id).orElse(null);
        if(customer_details==null){
            throw new CustomException("Customer not found with id " + id);
        }
        else{
            customerDetailsRepository.deleteById(id);
            return true;

        }

    }


}
