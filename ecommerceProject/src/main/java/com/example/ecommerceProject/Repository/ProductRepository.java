package com.example.ecommerceProject.Repository;

import com.example.ecommerceProject.Entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
