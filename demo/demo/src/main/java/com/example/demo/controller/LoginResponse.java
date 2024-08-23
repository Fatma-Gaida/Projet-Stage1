package com.example.demo.controller;

public class LoginResponse {
    private Long id;
    private String accountType;

    public LoginResponse(Long id, String accountType) {
        this.id = id;
        this.accountType = accountType;
    }

    public Long getId() {
        return id;
    }

    public String getAccountType() {
        return accountType;
    }
}
