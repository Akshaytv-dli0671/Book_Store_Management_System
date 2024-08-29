package com.BSMS.Book_Store_ManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
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

//    @NotNull(message = "User Name is required")
    @Column(unique = true)
    private String user_name;

//    @NotNull(message = "User Email is required")
    private String user_email;

//    @NotNull(message = "User Password is required")
    private String user_password;

//    @NotNull(message = "Created date is required")
    private Timestamp user_created_at;

    @OneToOne(mappedBy = "user")
    private Cart cart;


}
