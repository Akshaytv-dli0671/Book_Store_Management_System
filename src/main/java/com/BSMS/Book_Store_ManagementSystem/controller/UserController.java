package com.BSMS.Book_Store_ManagementSystem.controller;
import com.BSMS.Book_Store_ManagementSystem.dto.Logindto;
import com.BSMS.Book_Store_ManagementSystem.exception.CustomException;
import com.BSMS.Book_Store_ManagementSystem.model.User;
import com.BSMS.Book_Store_ManagementSystem.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
        boolean isAuthenticated = userService.loginUser(logindto.getUsername(),logindto.getPassword());
        System.out.println(isAuthenticated);
        if (isAuthenticated) {
            return ResponseEntity.ok("Login successful");
        } else {
            throw  new CustomException("Invalid User name or password");
        }
    }

}
