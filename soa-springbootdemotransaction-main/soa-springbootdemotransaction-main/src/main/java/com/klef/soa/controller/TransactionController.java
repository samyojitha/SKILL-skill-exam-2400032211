package com.klef.soa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.klef.soa.entity.Transaction;
import com.klef.soa.service.TransactionService;

@RestController
@RequestMapping("/transaction")
public class TransactionController
{
    @Autowired
    private TransactionService service;

    @GetMapping("/")
    public String demo()
    {
        return "Transaction Service Running";
    }

    // Add Transaction
    @PostMapping("/add")
    public ResponseEntity<Transaction> addTransaction(@RequestBody Transaction t)
    {
        Transaction transaction = service.addTransaction(t);
        return ResponseEntity.status(201).body(transaction);
    }

    // Display All Transactions
    @GetMapping("/displayall")
    public ResponseEntity<List<Transaction>> displayAllTransactions()
    {
        List<Transaction> transactions = service.displayAllTransactions();
        return ResponseEntity.ok(transactions);
    }

    // Display Transaction By ID
    @GetMapping("/display")
    public ResponseEntity<?> displayTransactionById(@RequestParam Long id)
    {
        Transaction transaction = service.displayTransactionById(id);

        if(transaction != null)
        {
            return ResponseEntity.ok(transaction);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Transaction ID Not Found");
        }
    }

    // Update Transaction
    @PutMapping("/update")
    public ResponseEntity<?> updateTransaction(@RequestBody Transaction t)
    {
        Transaction transaction = service.updateTransaction(t);

        if(transaction != null)
        {
            return ResponseEntity.ok(transaction);
        }
        else
        {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Transaction ID Not Found");
        }
    }

    // Delete Transaction
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteTransaction(@PathVariable Long id)
    {
        String message = service.deleteTransactionById(id);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    // Display By Name
    @GetMapping("/displaybyname/{name}")
    public ResponseEntity<List<Transaction>> displayTransactionsByName(@PathVariable String name)
    {
        List<Transaction> transactions = service.displayTransactionsByName(name);
        return ResponseEntity.ok(transactions);
    }

    // Display By Type
    @GetMapping("/displaybytype/{type}")
    public ResponseEntity<List<Transaction>> displayTransactionsByType(@PathVariable String type)
    {
        List<Transaction> transactions = service.displayTransactionsByType(type);
        return ResponseEntity.ok(transactions);
    }

    // Transaction Count
    @GetMapping("/count")
    public ResponseEntity<String> transactionCount()
    {
        Long count = service.transactionCount();
        return ResponseEntity.ok("Total Transactions = " + count);
    }
}