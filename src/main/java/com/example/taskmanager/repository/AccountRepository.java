package com.example.taskmanager.repository;

import com.example.taskmanager.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {
}
