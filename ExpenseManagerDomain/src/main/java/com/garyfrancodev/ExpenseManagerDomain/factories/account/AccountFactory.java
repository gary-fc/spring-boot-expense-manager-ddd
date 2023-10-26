package com.garyfrancodev.ExpenseManagerDomain.factories.account;

import com.garyfrancodev.ExpenseManagerDomain.model.Account;
import com.garyfrancodev.ExpenseManagerDomain.model.User;

import java.util.UUID;

public interface AccountFactory {
    Account create(String accountName, String description, double amount, UUID userid);
}
