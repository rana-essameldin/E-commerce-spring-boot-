package com.example.ecommerceProject.Entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;
import java.util.List;
@Entity
@Table(name = "`order`")

public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany
    @JoinColumn(name = "order_id", referencedColumnName = "id")
    @NotNull(message = "Order items cannot be null")
    private List<CartItem> items;
    private LocalDateTime orderDate;
    private double totalAmount;
    public Order() {}
    public Order(List<CartItem> items, LocalDateTime orderDate, double totalAmount) {
        this.items = items;
        this.orderDate = orderDate;
        this.totalAmount = totalAmount;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public List<CartItem> getItems() {
        return items;
    }
    public void setItems(List<CartItem> items) {
        this.items = items;
    }
    public LocalDateTime getOrderDate() {
        return orderDate;
    }
    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }
    public double getTotalAmount() {
        return totalAmount;
    }
    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

}
