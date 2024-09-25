package com.example.ecommerceProject.Controller;

import com.example.ecommerceProject.Entity.Transaction;
import com.example.ecommerceProject.Entity.User;
import com.example.ecommerceProject.Entity.Wallet;
import com.example.ecommerceProject.Service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class WalletController {
    @Autowired
    private WalletService walletService;

    @PostMapping("/wallet/create")
    public Wallet createWallet(@RequestBody User user) {
        return walletService.createWallet(user);
    }

    @PostMapping("/{walletId}/deposit")
    public Wallet deposit(@PathVariable Long walletId, @RequestParam double amount) {
        return walletService.deposit(walletId, amount);
    }

    @PostMapping("/{walletId}/withdraw")
    public Wallet withdraw(@PathVariable Long walletId, @RequestParam double amount) {
        return walletService.withdraw(walletId, amount);
    }

    @GetMapping("/{walletId}/transactions")
    public List<Transaction> getTransactionHistory(@PathVariable Long walletId) {
        return walletService.getTransactionHistory(walletId);
    }
}
