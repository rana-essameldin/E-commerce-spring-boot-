package com.example.ecommerceProject.Service;

import com.example.ecommerceProject.Entity.Transaction;
import com.example.ecommerceProject.Entity.User;
import com.example.ecommerceProject.Entity.Wallet;
import com.example.ecommerceProject.Repository.TransactionRepository;
import com.example.ecommerceProject.Repository.WalletRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WalletService {
    @Autowired
    private WalletRepository walletRepository;
    @Autowired
    private TransactionRepository transactionRepository;

    public Wallet createWallet(User user) {
        Wallet wallet = new Wallet();
        wallet.setUser(user);
        wallet.setBalance(0.0);
        return walletRepository.save(wallet);
    }

    public Wallet deposit(Long walletId, double amount) {
        Wallet wallet = walletRepository.findById(walletId).orElseThrow();
        wallet.setBalance(wallet.getBalance() + amount);
        walletRepository.save(wallet);

        Transaction transaction = new Transaction();
        transaction.setWallet(wallet);
        transaction.setAmount(amount);
        transaction.setTimestamp(LocalDateTime.now());
        transactionRepository.save(transaction);

        return wallet;
    }

    public Wallet withdraw(Long walletId, double amount) {
        Wallet wallet = walletRepository.findById(walletId).orElseThrow();
        if (wallet.getBalance() < amount) {
            throw new IllegalArgumentException("Insufficient funds");
        }
        wallet.setBalance(wallet.getBalance() - amount);
        walletRepository.save(wallet);

        Transaction transaction = new Transaction();
        transaction.setWallet(wallet);
        transaction.setAmount(-amount);
        transaction.setTimestamp(LocalDateTime.now());
        transactionRepository.save(transaction);

        return wallet;
    }

    public List<Transaction> getTransactionHistory(Long walletId) {
        Wallet wallet = walletRepository.findById(walletId).orElseThrow();
        return transactionRepository.findAllByWallet(wallet);
    }
}
