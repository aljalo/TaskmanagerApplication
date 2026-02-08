package com.example.taskmanager.dto;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

// DTO to receive data from client
public class AccountRequestDTO {
    @NotBlank(message = "Owner is required")
    private String ownerName;

    @NotNull(message = "Balance is required")
    @Min(value = 0, message = "Balance must be positive")
    private double balance;

    public String getOwnerName(){
        return ownerName;
    }

    public Double getBalance(){
        return balance;
    }

}
