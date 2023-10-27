package com.garyfrancodev.ExpenseManagerDomain.model;

import com.garyfrancodev.ExpenseManagerSharedKernel.core.AggregateRoot;

import java.util.UUID;

public class Account extends AggregateRoot {
    private String accountName;
    private String description;
    private double amount;
    private UUID userId;

    public Account(double amount) {
        this.amount = amount;
    }

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
    public void updateAmount(Double updateAmount){
        this.amount = updateAmount;
    }
    public void increaseAmount(Double updateAmount){
        this.amount = this.amount + updateAmount;
    };

    public void decreaseAmount(Double updateAmount){
        this.amount = this.amount - updateAmount;
    };

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
