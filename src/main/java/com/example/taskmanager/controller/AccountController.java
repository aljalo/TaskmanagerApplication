package com.example.taskmanager.controller;

import com.example.taskmanager.dto.AccountRequestDTO;
import com.example.taskmanager.dto.AccountResponseDTO;
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
//    public ResponseEntity<List<Account>> getAllAccounts(){
//        return ResponseEntity.ok(accountService.getAllAccounts());
//    }
    public ResponseEntity<List<AccountResponseDTO>> getAllAccounts(){
        List<AccountResponseDTO> response = accountService.getAllAccounts().stream().map(this::toResponse).toList();

        return ResponseEntity.ok(response);
    }

    //GET by id
    @GetMapping("/{id}")
    public ResponseEntity<Account> getAccountById(@PathVariable Long id){
        Account account = accountService.getAccountById(id);

        return ResponseEntity.ok(accountService.getAccountById(id));
    }

    //CREATE
    @PostMapping
    public ResponseEntity<AccountResponseDTO> createAccount(
            @Valid @RequestBody AccountRequestDTO request){

        Account account = new Account(
                request.getOwnerName(),
                request.getBalance());

        Account saved = accountService.createAccount(account);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(toResponse(saved));
    }

    //UPDATE
    @PutMapping("/{id}")
    public ResponseEntity<AccountResponseDTO> updateAccount(
            @PathVariable Long id,
            @Valid @ RequestBody AccountRequestDTO request){

        Account updated = new Account(
                request.getOwnerName(),
                request.getBalance()
        );
        return ResponseEntity.ok(
                toResponse(accountService.updateAccount(id, updated))
        );
    }

    //DELETE
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAccount(@PathVariable Long id){
        accountService.deleteAccount(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }

    private AccountResponseDTO toResponse(Account account){
        return new AccountResponseDTO(
                account.getId(),
                account.getOwnerName(),
                account.getBalance()
        );
    }
}
