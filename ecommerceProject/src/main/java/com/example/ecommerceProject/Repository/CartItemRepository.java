package com.example.ecommerceProject.Repository;

import com.example.ecommerceProject.Entity.CartItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
}
