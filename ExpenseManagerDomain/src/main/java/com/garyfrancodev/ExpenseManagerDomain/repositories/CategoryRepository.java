package com.garyfrancodev.ExpenseManagerDomain.repositories;

import com.garyfrancodev.ExpenseManagerDomain.model.Category;
import com.garyfrancodev.ExpenseManagerDomain.model.User;

import java.util.UUID;

public interface CategoryRepository {
    UUID create(Category category);
}
