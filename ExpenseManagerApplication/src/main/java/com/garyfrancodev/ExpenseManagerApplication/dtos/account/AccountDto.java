package com.garyfrancodev.ExpenseManagerApplication.dtos.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
public class AccountDto {
    public String accountName;
    public String description;
    public double amount;
    private UUID userId;
    private UUID id;
}
