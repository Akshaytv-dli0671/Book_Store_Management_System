package com.BSMS.Book_Store_ManagementSystem.service;

import com.BSMS.Book_Store_ManagementSystem.model.Admin;

public interface AdminService {

    void registerAdmin(Admin admin);
    boolean authenticateAdmin(String username, String password);
}
