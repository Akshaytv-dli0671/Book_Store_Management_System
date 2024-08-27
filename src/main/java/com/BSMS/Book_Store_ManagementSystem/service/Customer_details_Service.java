package com.BSMS.Book_Store_ManagementSystem.service;

import com.BSMS.Book_Store_ManagementSystem.model.Customer_Details;

public interface Customer_details_Service {
    Customer_Details addCustomerDetails(Customer_Details customerDetails);
    Customer_Details updateCustomerDetails(Long id, Customer_Details customerDetails);
    boolean DeleteCustomerDetails(Long id);
}
