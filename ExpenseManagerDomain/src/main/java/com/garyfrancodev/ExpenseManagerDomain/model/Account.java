package com.garyfrancodev.ExpenseManagerDomain.model;

import com.garyfrancodev.ExpenseManagerSharedKernel.core.AggregateRoot;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

public class Account extends AggregateRoot {
    public String accountName;
    public String description;
    public double amount;
    private Collection<Account> accounts;

    public Account(String accountName, String description, double amount) {
        this.id = UUID.randomUUID();
        this.accountName = accountName;
    }
}
