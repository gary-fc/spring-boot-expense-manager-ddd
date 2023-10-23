package com.garyfrancodev.ExpenseManagerDomain.model;

import com.garyfrancodev.ExpenseManagerSharedKernel.core.AggregateRoot;

import java.util.List;

public class User extends AggregateRoot {

    private String firstName;
    private String lastName;
    private String email;

    public List<Account> accounts;
    public Category category;
}
