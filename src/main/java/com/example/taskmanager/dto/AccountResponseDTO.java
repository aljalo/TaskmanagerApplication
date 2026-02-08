package com.example.taskmanager.dto;

public class AccountResponseDTO {
    private Long id;
    private String ownerName;
    private double balance;

    public AccountResponseDTO(Long id , String ownerName, double balance) {
        this.id = id;
        this.ownerName = ownerName;
        this.balance = balance;
    }
    public Long getId(){
        return id;
    }
    public String getOwnerName(){
        return ownerName;
    }
    public double getBalance(){
        return balance;
    }
}
