package com.example.taskmanager.controller;

import com.example.taskmanager.dto.AccountRequestDTO;
import com.example.taskmanager.model.Account;
import com.example.taskmanager.service.AccountService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    private final AccountService accountService;

    public AccountController(AccountService accountService){
        this.accountService = accountService;
    }

    //GET all
    @GetMapping
    public ResponseEntity<List<Account>> getAllAccounts(){
        return ResponseEntity.ok(accountService.getAllAccounts());
    }

    //GET by id
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id){
        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    //CREATE
    @PostMapping
    public ResponseEntity<Account> createAccount(
            @Valid @RequestBody AccountRequestDTO request){

        Account account = new Account(
                request.getOwnerName(),
                request.getBalance());

        return ResponseEntity.status(HttpStatus.CREATED).body(accountService.createAccount(account));
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<Account> updateAccount(
            @PathVariable Long id,
            @Valid @ RequestBody AccountRequestDTO request){

        Account update = new Account(
                request.getOwnerName(),
                request.getBalance()
        );
        return ResponseEntity.ok(
                accountService.updateAccount(id, update)
        );
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}
