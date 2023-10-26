package com.garyfrancodev.ExpenseManagerDomain.factories.account;

import com.garyfrancodev.ExpenseManagerDomain.model.Account;
import com.garyfrancodev.ExpenseManagerDomain.model.User;

import java.util.UUID;

public class CreateAccount implements AccountFactory {
    @Override
    public Account create(String accountName, String description, double amount, UUID userId) {
        return new Account(accountName, description, amount, userId);
    }
}
