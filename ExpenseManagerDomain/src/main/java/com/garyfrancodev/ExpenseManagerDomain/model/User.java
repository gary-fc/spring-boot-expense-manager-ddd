package com.garyfrancodev.ExpenseManagerDomain.model;

import com.garyfrancodev.ExpenseManagerDomain.enums.CategoryType;
import com.garyfrancodev.ExpenseManagerSharedKernel.core.AggregateRoot;
import com.garyfrancodev.ExpenseManagerSharedKernel.core.BusinessRuleValidationException;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class User extends AggregateRoot {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    public List<Account> accounts;
    public List<Category> categories;
    private Date date;

    public User(String firstName, String lastName, String email, String password) {
        this.categories = new ArrayList<>();
        this.accounts = new ArrayList<>();
        this.id = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.date = new Date();
        this.email = email;
    }

    public User(String firstName, String lastName, String email, String password, List<Account> accounts, List<Category> categories) {
        this.id = UUID.randomUUID();
        this.categories = categories;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.accounts = accounts;
        this.date = new Date();
        this.email = email;
    }

    public void addCategory(String categoryName, String categoryDescription, String categoryIcon, CategoryType categoryType, User user) throws BusinessRuleValidationException {
        Category category = new Category(categoryIcon, categoryName, categoryDescription, categoryType, user);
        this.categories.add(category);
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public Date getDate() {
        return date;
    }

    public List<Category> getCategories() {
        return categories;
    }
}
