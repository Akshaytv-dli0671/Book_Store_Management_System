package com.BSMS.Book_Store_ManagementSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

    @Column(unique = true)
    @NotNull(message = "username is mandatory")
    @Column(unique = true)
    private String adminUsername;

    @NotNull(message = "Email is mandatory")
    private String adminEmail;

    @NotNull(message = "Password is mandatory")
    private String adminPassword;

    @NotNull(message = "created_at is mandatory")
    private Timestamp created_at;

}
