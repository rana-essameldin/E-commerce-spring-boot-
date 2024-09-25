package com.example.ecommerceProject.Controller;

import com.example.ecommerceProject.Entity.Inventory;
import com.example.ecommerceProject.Service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {

    @Autowired
    private InventoryService inventoryService;

    // Endpoint to add a new inventory item
    @PostMapping("/items")
    public Inventory addInventory(@RequestBody Inventory inventory) {
        return inventoryService.addInventory(inventory);
    }

    // Endpoint to get all inventory items
    @GetMapping("/items")
    public List<Inventory> getAllInventory() {
        return inventoryService.getAllInventory();
    }

    // Endpoint to get an inventory item by ID
    @GetMapping("/items/{id}")
    public Inventory getInventoryById(@PathVariable Long id) {
        return inventoryService.getInventoryById(id);
    }

    // Endpoint to update an inventory item's quantity
    @PutMapping("/items/{id}")
    public Inventory updateInventory(@PathVariable Long id, @RequestParam int quantity) {
        return inventoryService.updateInventory(id, quantity);
    }

    // Endpoint to delete an inventory item
    @DeleteMapping("/items/{id}")
    public void deleteInventory(@PathVariable Long id) {
        inventoryService.deleteInventory(id);
    }
}
