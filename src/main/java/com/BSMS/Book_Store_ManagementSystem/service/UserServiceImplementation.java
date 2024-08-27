package com.BSMS.Book_Store_ManagementSystem.service;

import com.BSMS.Book_Store_ManagementSystem.exception.CustomException;
import com.BSMS.Book_Store_ManagementSystem.model.Cart;
import com.BSMS.Book_Store_ManagementSystem.model.User;
import com.BSMS.Book_Store_ManagementSystem.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;


    @Override
    public User registerUser(User user) {
        user.setUser_password(passwordEncoder.encode(user.getUser_password()));
        String username = user.getUser_name();
        if (userRepository.findByUsername(username) != null) {
            throw new CustomException("User with this Username already exists.");
        }
        return userRepository.save(user);
    }

    @Override
    public boolean loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            return passwordEncoder.matches(password, user.getUser_password());
        }
        return false;
    }
}



