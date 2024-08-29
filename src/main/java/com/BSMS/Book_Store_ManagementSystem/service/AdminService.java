package com.BSMS.Book_Store_ManagementSystem.service;

import com.BSMS.Book_Store_ManagementSystem.model.Admin;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
public interface AdminService {

    void registerAdmin(Admin admin);
    boolean authenticateAdmin(String username, String password);

    UserDetails loadUserByUsername(String username);

    String generateToken(String adminUsername);

}
