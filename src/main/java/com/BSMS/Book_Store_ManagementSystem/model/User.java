package com.BSMS.Book_Store_ManagementSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
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
    private String user_name;

    @NotNull(message = "User Email is required")
    private String user_email;

    @NotNull(message = "User Password is required")
    private String user_password;

    @NotNull(message = "Created date is required")
    private Date user_created_at;

}
