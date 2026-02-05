package com.example.taskmanager.service;

import com.example.taskmanager.exception.AccountNotFoundException;
import com.example.taskmanager.model.Account;
import com.example.taskmanager.repository.AccountRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountServiceImpl implements AccountService {
//    @Override
//    public Account getAccount(){
//        return new Account(1L, "Ahmed" , 1500.0);
//    }
    private final AccountRepository accountRepository;

    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }
    @Override
    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }
    @Override
    public Account getAccountById(Long id){
        return accountRepository.findById(id).orElseThrow(() -> new AccountNotFoundException(id));
    }

}
