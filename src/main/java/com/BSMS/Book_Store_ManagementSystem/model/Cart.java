package com.BSMS.Book_Store_ManagementSystem.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.sql.Timestamp;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart_table")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cart_id;

    @OneToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull(message = "Created date is required")
    private Timestamp cart_created_at;


}
