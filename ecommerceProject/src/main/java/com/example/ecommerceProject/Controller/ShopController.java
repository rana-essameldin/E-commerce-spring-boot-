package com.example.ecommerceProject.Controller;

import com.example.ecommerceProject.Entity.*;
import com.example.ecommerceProject.Service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    private ShopService shopService;

    @PostMapping("/products")
    public Product addProduct(@RequestBody Product product) {
        return shopService.addProduct(product);
    }
    @DeleteMapping("/delete/{id}")
public void deleteProduct(@PathVariable int id) {
        shopService.deleteProduct(id);
    }
    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return shopService.getAllProducts();
    }

    @PostMapping("/cart/{productId}")
    public CartItem addToCart(@PathVariable Long productId, @RequestParam int quantity) {
        return shopService.addToCart(productId, quantity);
    }

    @GetMapping("/cart")
    public List<CartItem> getCartItems() {
        return shopService.getCartItems();
    }

    // Endpoint to place an order
    @PostMapping("/orders")
    public Order placeOrder(@RequestBody List<CartItem> cartItems) {
        return shopService.placeOrder(cartItems);
    }

    // Endpoint to process a payment for an order
    @PostMapping("/orders/{orderId}/payment")
    public Payment processPayment(@PathVariable Long orderId,
                                  @RequestParam double amount,
                                  @RequestParam String paymentMethod) {
        return shopService.processPayment(orderId, amount, paymentMethod);
    }

    // Endpoint to get all orders
    @GetMapping("/orders")
    public List<Order> getAllOrders() {
        return shopService.getAllOrders();
    }
}
