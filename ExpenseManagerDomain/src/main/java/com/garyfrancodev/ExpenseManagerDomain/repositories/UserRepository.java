package com.garyfrancodev.ExpenseManagerDomain.repositories;

import com.garyfrancodev.ExpenseManagerDomain.model.User;

import java.util.UUID;

public interface UserRepository {
    UUID create(User user);
}
