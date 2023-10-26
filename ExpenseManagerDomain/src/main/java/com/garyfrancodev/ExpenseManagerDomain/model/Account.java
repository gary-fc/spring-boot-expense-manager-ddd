package com.garyfrancodev.ExpenseManagerDomain.model;

import com.garyfrancodev.ExpenseManagerSharedKernel.core.AggregateRoot;

import java.util.UUID;

public class Account extends AggregateRoot {
    private String accountName;
    private String description;
    private double amount;
    private UUID userId;


    public Account(String accountName, String description, double amount, UUID userId) {
        this.accountName = accountName;
        this.description = description;
        this.id = UUID.randomUUID();
        this.amount = amount;
        this.userId = userId;
    }

    public Account(String accountName, String description, double amount, UUID userId, UUID id) {
        this.accountName = accountName;
        this.description = description;
        this.amount = amount;
        this.userId = userId;
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public String getDescription() {
        return description;
    }

    public double getAmount() {
        return amount;
    }

    public UUID getUserId() {
        return userId;
    }
}
