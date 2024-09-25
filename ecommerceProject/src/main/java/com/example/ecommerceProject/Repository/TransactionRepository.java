package com.example.ecommerceProject.Repository;

import com.example.ecommerceProject.Entity.Transaction;
import com.example.ecommerceProject.Entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    List<Transaction> findAllByWallet(Wallet wallet);
}
