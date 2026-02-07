package com.example.taskmanager.repository;

import com.example.taskmanager.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    List<Account> findAll();

    Optional<Account> findById(Long id);

    Account save (Account account);

    Account update(Long id, Account account);
}
