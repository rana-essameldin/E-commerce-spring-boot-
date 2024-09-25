package com.example.ecommerceProject.Repository;

import com.example.ecommerceProject.Entity.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet, Long> {
}
