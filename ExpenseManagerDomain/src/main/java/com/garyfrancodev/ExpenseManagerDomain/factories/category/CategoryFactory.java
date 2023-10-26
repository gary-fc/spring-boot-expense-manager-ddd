package com.garyfrancodev.ExpenseManagerDomain.factories.category;

import com.garyfrancodev.ExpenseManagerDomain.enums.CategoryType;
import com.garyfrancodev.ExpenseManagerDomain.model.Category;
import com.garyfrancodev.ExpenseManagerDomain.model.User;
import com.garyfrancodev.ExpenseManagerSharedKernel.core.BusinessRuleValidationException;

import java.util.UUID;

public interface CategoryFactory {
    Category create(String categoryIcon, String categoryName, String categoryDescription, CategoryType categoryType, UUID userId) throws BusinessRuleValidationException;
}
