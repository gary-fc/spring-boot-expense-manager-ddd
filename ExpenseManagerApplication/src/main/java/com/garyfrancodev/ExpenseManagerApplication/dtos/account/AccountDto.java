package com.garyfrancodev.ExpenseManagerApplication.dtos.account;

import lombok.AllArgsConstructor;

import java.util.UUID;

@AllArgsConstructor
public class AccountDto {
    public String accountName;
    public String description;
    public double amount;
    private UUID userId;
    private UUID id;
}
