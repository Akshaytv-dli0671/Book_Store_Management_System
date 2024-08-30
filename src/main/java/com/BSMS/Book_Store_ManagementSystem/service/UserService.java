package com.BSMS.Book_Store_ManagementSystem.service;

import com.BSMS.Book_Store_ManagementSystem.model.User;

public interface UserService{
    User registerUser(User user);
    String loginUser(String username, String password);

    boolean verifyToken(String token);
}
