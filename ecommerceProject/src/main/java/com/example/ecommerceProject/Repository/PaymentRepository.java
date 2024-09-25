package com.example.ecommerceProject.Repository;

import com.example.ecommerceProject.Entity.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
