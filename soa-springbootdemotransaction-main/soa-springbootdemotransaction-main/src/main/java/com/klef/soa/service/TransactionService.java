package com.klef.soa.service;

import java.util.List;

import com.klef.soa.entity.Transaction;

public interface TransactionService
{
    Transaction addTransaction(Transaction t);

    Transaction updateTransaction(Transaction t);

    List<Transaction> displayAllTransactions();

    Transaction displayTransactionById(Long id);

    String deleteTransactionById(Long id);

    List<Transaction> displayTransactionsByName(String name);

    List<Transaction> displayTransactionsByType(String type);

    Long transactionCount();
}