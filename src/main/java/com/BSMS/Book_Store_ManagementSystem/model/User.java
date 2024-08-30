package com.BSMS.Book_Store_ManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "user_id")
@Table(name = "users_table")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long user_id;

    @NotNull(message = "User Name is required")
    @Column(unique = true)
    private String user_name;

    @NotNull(message = "User Email is required")
    private String user_email;


    @NotNull(message = "User Password is required")
    @Size(min = 8, message = "Password must be at least 8 characters long")
    @Pattern(regexp = "^[A-Za-z0-9]*[!@#$%^&*()_+\\-=\\[\\]{};':\"\\\\|,.<>\\/?].*$", message = "Password must contain at least one special character")
    private String user_password;


    private Timestamp user_created_at;

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + user_id +
                ", user_name='" + user_name + '\'' +
                ", user_email='" + user_email + '\'' +
                ", user_created_at=" + user_created_at +
                '}';
    }



}
