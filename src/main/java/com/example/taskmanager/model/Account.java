package com.example.taskmanager.model;

public class Account {
    private Long id;
    private String ownerName;
    private double balance;

    public Account(Long id, String ownerName, double balance){
        this.id = id;
        this.ownerName = ownerName;
        this.balance = balance;
    }
    public Account(String ownerName, double balance){
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
    public void setOwnerName(String ownerName){
        this.ownerName = ownerName;
    }
    public void setBalance(double balance){
        this.balance = balance;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return id != null && id.equals(account.id);
    }
    @Override
    public int hashCode(){
        return id != null ? id.hashCode() : 0;
    }
}
