package com.example.ecommerceProject.Entity;
import jakarta.validation.constraints.NotNull;

import jakarta.validation.constraints.Positive;

import jakarta.persistence.*;

@Entity
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "id")
    @NotNull(message = "Product ID cannot be null")
    private Product product;
    @Positive(message = "Quantity must be a positive number")
    private int quantity;

    public Inventory() {}
    public Inventory(Product product, int quantity) {
        this.product = product;
        this.quantity = quantity;

    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Product getProduct() {
        return product;
    }
    public void setProduct(Product product) {
        this.product = product;
    }
    public int getQuantity() {
        return quantity;
    }
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

}