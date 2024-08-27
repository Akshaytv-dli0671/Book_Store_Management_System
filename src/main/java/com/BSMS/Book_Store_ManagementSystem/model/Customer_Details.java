package com.BSMS.Book_Store_ManagementSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "customer_details")
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer_Details {
    @Id

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long customer_details_id;
    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;
    private String name;
    @Email
    private String email;
    private String address;
    private String phoneNumber;

}
