package com.garyfrancodev.ExpenseManagerInfrastructure.model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "categories")
public class CategoryJpaModel {
    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String categoryName;

    @Column(nullable = false)
    private String categoryIcon;

    @Column
    private String categoryDescription;

    @ManyToOne
    private UserJpaModel user;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryIcon() {
        return categoryIcon;
    }

    public void setCategoryIcon(String categoryIcon) {
        this.categoryIcon = categoryIcon;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public UserJpaModel getUser() {
        return user;
    }

    public void setUser(UserJpaModel user) {
        this.user = user;
    }
}
