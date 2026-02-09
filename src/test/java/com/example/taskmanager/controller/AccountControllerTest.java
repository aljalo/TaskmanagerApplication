package com.example.taskmanager.controller;

import com.example.taskmanager.model.Account;
import com.example.taskmanager.service.AccountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@WebMvcTest(AccountController.class)
class AccountControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AccountService accountService;

    @Test
    void shouldReturn200WhenGetAllAccounts() throws Exception {
        mockMvc.perform(get("/accounts"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnAllAccounts() throws Exception {

        List<Account> accounts = List.of(
                new Account("Ahmed", 1500.0),
                new Account("Sara", 2500.0)
        );

        when(accountService.getAllAccounts()).thenReturn(accounts);

        mockMvc.perform(get("/accounts"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].ownerName").value("Ahmed"));
    }

    @Test
    void shouldReturnAccountById() throws Exception {

        Account account = new Account("Ahmed", 1500.0);
        when(accountService.getAccountById(1L)).thenReturn(account);

        mockMvc.perform(get("/accounts/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.ownerName").value("Ahmed"));
    }

    @Test
    void shouldReturn404WhenAccountNotFound() throws Exception {

        when(accountService.getAccountById(99L))
                .thenThrow(new RuntimeException("Account not found"));

        mockMvc.perform(get("/accounts/99"))
                .andExpect(status().isNotFound());
    }

    @Test
    void shouldCreateAccount() throws Exception {

        Account account = new Account("Ali", 2000.0);
        when(accountService.createAccount(any(Account.class)))
                .thenReturn(account);

        String json = """
        {
          "ownerName": "Ali",
          "balance": 2000
        }
        """;

        mockMvc.perform(post("/accounts")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(json))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.ownerName").value("Ali"));
    }

    @Test
    void shouldDeleteAccount() throws Exception {

        doNothing().when(accountService).deleteAccount(1L);

        mockMvc.perform(delete("/accounts/1"))
                .andExpect(status().isNoContent());
    }
}
