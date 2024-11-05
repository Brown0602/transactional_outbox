package com.tuaev.order_service.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Entity
@Table(name = "orders")
@Getter
@Setter
public class Order {
    public Order(String address, String paymentMethod, String comments, String userEmail, User user, LocalDateTime dateTime) {
        this.address = address;
        this.paymentMethod = paymentMethod;
        this.comments = comments;
        this.userEmail = userEmail;
        this.user = user;
        this.dateTime = dateTime;
    }

    public Order() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "address")
    private String address;
    @Column(name = "payment_method")
    private String paymentMethod;
    @Column(name = "comments")
    private String comments;
    @Column(name = "user_email")
    private String userEmail;
    @ManyToOne
    private User user;
    @Column(name = "datetime")
    private LocalDateTime dateTime;
}
