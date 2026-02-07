package com.example.taskmanager.service;

import com.example.taskmanager.model.Account;

import java.util.List;

public interface AccountService {

   // Account getAccount();

    List<Account> getAllAccounts();

    Account getAccountById(Long id);

    Account createAccount(Account account);

    Account updateAccount(Long id, Account account);

    void deleteAccount(long id);
}
