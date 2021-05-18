package com.example.bankingapp;

public class User {
    String name,balance;
    public User(String name,String balance){
        this.name=name;
        this.balance=balance;
    }
    String getName(){
        return this.name;
    }
    String getBalance(){
        return this.balance;
    }
}
