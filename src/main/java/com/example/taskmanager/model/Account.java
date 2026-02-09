package com.example.taskmanager.model;

import jakarta.persistence.*;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ownerName;
    private Double balance;

    protected Account() {
        // JPA only
    }

    public Account(String ownerName, Double balance) {
        this.ownerName = ownerName;
        this.balance = balance;
    }

    // Getters
    public Long getId() {
        return id;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public Double getBalance() {
        return balance;
    }

    // Setters
    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }
}
