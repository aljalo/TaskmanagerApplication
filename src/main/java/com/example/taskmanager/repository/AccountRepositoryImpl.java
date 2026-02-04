package com.example.taskmanager.repository;

import com.example.taskmanager.model.Account;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class AccountRepositoryImpl implements AccountRepository {
    private final List<Account> accounts = new ArrayList<>();

    public AccountRepositoryImpl(){
        accounts.add(new Account(1L, "Ahmed", 1500.0));
        accounts.add(new Account(2L, "Sara", 2500.0));
    }
   @Override
    public List<Account> findAll(){
        return accounts;
    }
    @Override
    public Optional<Account> findById(Long id){
        return accounts.stream().filter(account -> account.getId().equals(id)).findFirst();
    }
}
