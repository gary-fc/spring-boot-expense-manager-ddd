package com.garyfrancodev.ExpenseManagerDomain.model;

import com.garyfrancodev.ExpenseManagerDomain.enums.CategoryType;
import com.garyfrancodev.ExpenseManagerSharedKernel.core.AggregateRoot;
import com.garyfrancodev.ExpenseManagerSharedKernel.core.BusinessRuleValidationException;
import com.garyfrancodev.ExpenseManagerSharedKernel.valueobjects.CategoryNameValue;

import java.util.UUID;

public class Category extends AggregateRoot {
    private String categoryDescription;
    private String categoryIcon;
    private CategoryNameValue categoryName;
    private User user;

    private CategoryType categoryType;

    public Category(String categoryIcon, String categoryName, String categoryDescription, CategoryType categoryType, User user) throws BusinessRuleValidationException {
        this.categoryName = new CategoryNameValue(categoryName);
        this.categoryDescription = categoryDescription;
        this.categoryIcon = categoryIcon;
        this.categoryType = categoryType;
        this.id = UUID.randomUUID();
        this.user = user;
    }

    public CategoryType getCategoryType() {
        return categoryType;
    }

    public String getCategoryIcon() {
        return categoryIcon;
    }

    public CategoryNameValue getCategoryName() {
        return categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public User getUser() {
        return user;
    }
}
