package com.garyfrancodev.ExpenseManagerDomain.repositories;

import com.garyfrancodev.ExpenseManagerDomain.enums.CategoryType;
import com.garyfrancodev.ExpenseManagerDomain.model.Category;
import com.garyfrancodev.ExpenseManagerDomain.model.User;
import com.garyfrancodev.ExpenseManagerSharedKernel.core.BusinessRuleValidationException;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository {
    UUID create(Category category);

    List<Category> getCategoriesByUserId(UUID userId);

    Category getCategoryDefaultByUserByCategoryType(UUID userId, String nameDefault) throws BusinessRuleValidationException;
}
