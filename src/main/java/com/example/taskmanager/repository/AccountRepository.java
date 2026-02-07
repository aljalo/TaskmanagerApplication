package com.example.taskmanager.repository;

import com.example.taskmanager.model.Account;

import java.util.List;
import java.util.Optional;

public interface AccountRepository {
    List<Account> findAll();

    Optional<Account> findById(Long id);

    //CREATE
    Account save (Account account);

    //UPDATE
    Account update(Long id, Account account);

    // DELETE
    void deleteById(Long id);
}
