package com.garyfrancodev.ExpenseManagerDomain.factories.user;

import com.garyfrancodev.ExpenseManagerDomain.model.Account;
import com.garyfrancodev.ExpenseManagerDomain.model.Category;
import com.garyfrancodev.ExpenseManagerDomain.model.User;

import java.util.List;

public interface UserFactory {
    User create(String firstName, String lastName, String email, String password);
}
