package com.BSMS.Book_Store_ManagementSystem.service;

import com.BSMS.Book_Store_ManagementSystem.exception.CustomException;
import com.BSMS.Book_Store_ManagementSystem.model.Cart;
import com.BSMS.Book_Store_ManagementSystem.model.Order;
import com.BSMS.Book_Store_ManagementSystem.model.User;
import com.BSMS.Book_Store_ManagementSystem.repository.CartRepository;
import com.BSMS.Book_Store_ManagementSystem.repository.OrderRepository;
import com.BSMS.Book_Store_ManagementSystem.repository.UserRepository;
import com.BSMS.Book_Store_ManagementSystem.util.JwtUtil;
import org.apache.coyote.BadRequestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Autowired
    CartRepository cartRepository;

    @Autowired
    OrderRepository orderRepository;

    @Autowired
    JwtUtil jwtUtil;

    @Transactional
    @Override
    public User registerUser(User user) {
        user.setUser_created_at(Timestamp.valueOf(LocalDateTime.now()));
        user.setUser_password(passwordEncoder.encode(user.getUser_password()));
        String username = user.getUser_name();
        if (userRepository.findByUsername(username) != null) {
            throw new CustomException("User with this Username already exists.");
        }
        User saveUser=userRepository.save(user);
        Cart cart = new Cart();
        cart.setUser(saveUser);
        cart.setCart_created_at(new Timestamp(System.currentTimeMillis()));
        cartRepository.save(cart);
        return saveUser;
    }

    @Override
    public String loginUser(String username, String password) {
        User user = userRepository.findByUsername(username);
        if (user != null) {
            if(passwordEncoder.matches(password, user.getUser_password()))
            {
                return jwtUtil.generateToken(user.getUser_name());
            }
            else
            {
                throw new BadCredentialsException("Invalid Credentials!");
            }
        }
        else
            throw new CustomException("User not found!");
    }

    @Override
    public boolean verifyToken(String token) {
        String username = jwtUtil.extractUsername(token);
        Optional<User> userOptional = Optional.ofNullable(userRepository.findByUsername(username));

        if (userOptional.isPresent()) {
            return jwtUtil.validateToken(token,username);
        }
        return false;
    }
}



