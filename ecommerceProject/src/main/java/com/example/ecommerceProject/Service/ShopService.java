package com.example.ecommerceProject.Service;

import com.example.ecommerceProject.Entity.*;
import com.example.ecommerceProject.Repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ShopService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private CartItemRepository cartItemRepository;

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private PaymentRepository paymentRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }
    public String deleteProduct(long id) {
        productRepository.deleteById(id);
        return "Product deleted";

    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public CartItem addToCart(Long productId, int quantity) {
        Optional<Product> productOpt = productRepository.findById(productId);
        if (!productOpt.isPresent()) {
            throw new IllegalArgumentException("Product not found");
        }

        Product product = productOpt.get();
        CartItem cartItem = new CartItem();
        cartItem.setProduct(product);
        cartItem.setQuantity(quantity);

        return cartItemRepository.save(cartItem);
    }

    // Method to retrieve all items in the shopping cart
    public List<CartItem> getCartItems() {
        return cartItemRepository.findAll();
    }

    // Method to place an order
    public Order placeOrder(List<CartItem> cartItems) {
        double totalAmount = cartItems.stream()
                .mapToDouble(item -> item.getProduct().getPrice() * item.getQuantity())
                .sum();

        Order order = new Order();
        order.setItems(cartItems);
        order.setOrderDate(LocalDateTime.now());
        order.setTotalAmount(totalAmount);
        orderRepository.save(order);
        cartItemRepository.deleteAll(cartItems);
        return order;
    }

    public Payment processPayment(Long orderId, double amount, String paymentMethod) {
        Optional<Order> orderOpt = orderRepository.findById(orderId);
        if (!orderOpt.isPresent()) {
            throw new IllegalArgumentException("Order not found");
        }
        Order order = orderOpt.get();
        if (amount != order.getTotalAmount()) {
            throw new IllegalArgumentException("Payment amount does not match order total");
        }
        Payment payment = new Payment();
        payment.setOrder(order);
        payment.setAmount(amount);
        payment.setPaymentMethod(paymentMethod);

        return paymentRepository.save(payment);
    }

    public List<Order> getAllOrders() {
        return orderRepository.findAll();
    }
}
