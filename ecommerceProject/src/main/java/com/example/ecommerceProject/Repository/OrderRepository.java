package com.example.ecommerceProject.Repository;

import com.example.ecommerceProject.Entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {
}
