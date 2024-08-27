package com.BSMS.Book_Store_ManagementSystem.service;

import com.BSMS.Book_Store_ManagementSystem.repository.CustomerDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Customer_details_Implementation implements Customer_details_Service{
    @Autowired
    CustomerDetailsRepository customerDetailsRepository;
}
