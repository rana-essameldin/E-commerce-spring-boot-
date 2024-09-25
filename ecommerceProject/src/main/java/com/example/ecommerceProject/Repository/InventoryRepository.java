package com.example.ecommerceProject.Repository;

import com.example.ecommerceProject.Entity.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
