package com.klef.soa.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.klef.soa.entity.Transaction;
import com.klef.soa.repository.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService
{

    @Autowired
    private TransactionRepository repo;

    @Override
    public Transaction addTransaction(Transaction t)
    {
        return repo.save(t);
    }

    @Override
    public Transaction updateTransaction(Transaction t)
    {
        Optional<Transaction> optional = repo.findById(t.getTransactionId());

        if(optional.isPresent())
        {
            Transaction transaction = optional.get();

            transaction.setName(t.getName());
            transaction.setType(t.getType());
            transaction.setStatus(t.getStatus());
            transaction.setLocation(t.getLocation());

            return repo.save(transaction);
        }
        else
        {
            return null;
        }
    }

    @Override
    public List<Transaction> displayAllTransactions()
    {
        return repo.findAll();
    }

    @Override
    public Transaction displayTransactionById(Long id)
    {
        return repo.findById(id).orElse(null);
    }

    @Override
    public String deleteTransactionById(Long id)
    {
        boolean flag = repo.existsById(id);

        if(flag)
        {
            repo.deleteById(id);
            return "Transaction Deleted Successfully";
        }
        else
        {
            return "Transaction ID Not Found";
        }
    }

    @Override
    public List<Transaction> displayTransactionsByName(String name)
    {
        return repo.findByName(name);
    }

    @Override
    public List<Transaction> displayTransactionsByType(String type)
    {
        return repo.findByType(type);
    }

    @Override
    public Long transactionCount()
    {
        return repo.count();
    }
}