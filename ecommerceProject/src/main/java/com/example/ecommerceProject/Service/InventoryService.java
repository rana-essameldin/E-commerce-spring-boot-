package com.example.ecommerceProject.Service;

import com.example.ecommerceProject.Entity.Inventory;
import com.example.ecommerceProject.Repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;

    // Method to add a new inventory item
    public Inventory addInventory(Inventory inventory) {
        return inventoryRepository.save(inventory);
    }

    // Method to retrieve all inventory items
    public List<Inventory> getAllInventory() {
        return inventoryRepository.findAll();
    }

    // Method to get an inventory item by its ID
    public Inventory getInventoryById(Long id) {
        Optional<Inventory> inventory = inventoryRepository.findById(id);
        return inventory.orElseThrow(() -> new IllegalArgumentException("Inventory item not found"));
    }

    // Method to update the inventory level of an item
    public Inventory updateInventory(Long id, int quantity) {
        Inventory inventory = getInventoryById(id);
        inventory.setQuantity(quantity);
        return inventoryRepository.save(inventory);
    }

    // Method to delete an inventory item
    public void deleteInventory(Long id) {
        Inventory inventory = getInventoryById(id);
        inventoryRepository.delete(inventory);
    }
}
