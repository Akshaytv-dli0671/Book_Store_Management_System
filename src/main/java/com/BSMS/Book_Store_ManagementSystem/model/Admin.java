package com.BSMS.Book_Store_ManagementSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.cglib.core.Local;

import java.sql.Timestamp;
import java.time.LocalDateTime;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "admin_table")
public class Admin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long adminId;

    @NotNull(message = "username is mandatory")
    @Column(unique = true)
    @Pattern(regexp = "^[a-zA-Z0-9]{5,15}$", message = "Admin username must be alphanumeric and between 5 to 15 characters long")
    private String adminUsername;

    @NotNull(message = "Email is mandatory")
    @Pattern(regexp = "^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$", message = "Invalid email")
    private String adminEmail;

    @NotNull(message = "Password is mandatory")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = "^[A-Za-z0-9]*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*$", message = "Password must contain at least one special character")
    private String adminPassword;

    @NotNull(message = "created_at is mandatory")
    private Timestamp created_at;



}
