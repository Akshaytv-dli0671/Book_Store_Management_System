package com.BSMS.Book_Store_ManagementSystem.controller;
import com.BSMS.Book_Store_ManagementSystem.dto.Logindto;
import com.BSMS.Book_Store_ManagementSystem.exception.CustomException;
import com.BSMS.Book_Store_ManagementSystem.model.User;
import com.BSMS.Book_Store_ManagementSystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Collections;

@RestController
@CrossOrigin
@RequestMapping("/bookstore_user")
public class UserController {
    @Autowired
    UserService userService;
    @PostMapping("/registration")
    public ResponseEntity<User> userRegistration(@Valid @RequestBody User user) {
        User registeredUser = userService.registerUser(user);
        return ResponseEntity.ok(registeredUser);
    }

    @PostMapping("/login")
    public ResponseEntity<?> loginUser(@Valid @RequestBody Logindto logindto) {
        String token = userService.loginUser(logindto.getUsername(),logindto.getPassword());
        return ResponseEntity.ok(Collections.singletonMap("token",token));
    }

    @PostMapping("/verification/{token}")
    public ResponseEntity<?> userVerification(@PathVariable String token) {
        boolean isVerified = userService.verifyToken(token);
        if (isVerified) {
            return ResponseEntity.ok("User account verified successfully!");
        } else {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid or expired token.");
        }
    }


}
