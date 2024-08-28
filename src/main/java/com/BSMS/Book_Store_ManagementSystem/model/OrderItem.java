package com.BSMS.Book_Store_ManagementSystem.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Orders_item_table")
public class OrderItem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private Order order;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "product_id", nullable = false)
    private Products product;


    private Integer quantity;

    private BigDecimal price;

}
