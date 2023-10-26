package com.garyfrancodev.ExpenseManagerApplication.dtos.account;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CreateAccountDto {
    public String accountName;
    public String description;
    public double amount;
    private UUID userId;

}
