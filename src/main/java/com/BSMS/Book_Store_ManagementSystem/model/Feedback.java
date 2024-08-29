package com.BSMS.Book_Store_ManagementSystem.model;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "feedback")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "feedbackId")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotNull(message = "Id can't be null")
    private long feedbackId;

    @NotNull
    private int rating;

    @Column(columnDefinition = "TEXT")
    private String text;

    @NotNull
    private Timestamp createdAt;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "user_id")
    private User user;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name= "id")
    private Products product;

    public Feedback(int rating, String text, Timestamp createdAt, User user, Products product) {
        this.rating = rating;
        this.text = text;
        this.createdAt = createdAt;
        this.user = user;
        this.product = product;
    }
}
