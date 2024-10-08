package com.BSMS.Book_Store_ManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.boot.autoconfigure.web.WebProperties;

import java.sql.Timestamp;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "cart_table")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "cart_id")
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cart_id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @NotNull(message = "Created date is required")
    private Timestamp cart_created_at;

    @OneToMany(mappedBy = "cart")
    private List<CartItem> cartItems;

    @Override
    public String toString() {
        return "Cart{" +
                "cart_id=" + cart_id +
                ", cart_created_at=" + cart_created_at +
                '}';
    }


}
