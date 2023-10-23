package com.garyfrancodev.ExpenseManagerDomain.factories.user;

import com.garyfrancodev.ExpenseManagerDomain.model.Account;
import com.garyfrancodev.ExpenseManagerDomain.model.Category;
import com.garyfrancodev.ExpenseManagerDomain.model.User;

import java.util.List;

public class CreateUser implements UserFactory {

    @Override
    public User create(String firstName, String lastName, String email, String password) {
        return new User(firstName, lastName, email, password);
    }
}