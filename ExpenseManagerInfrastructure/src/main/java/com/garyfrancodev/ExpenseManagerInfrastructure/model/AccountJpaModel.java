package com.garyfrancodev.ExpenseManagerInfrastructure.model;

import jakarta.persistence.*;
import org.hibernate.annotations.ManyToAny;

import java.util.UUID;

@Entity
@Table(name = "accounts")
public class AccountJpaModel {
    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private String accountName;
    @Column(nullable = false)
    private String description;
    @Column(nullable = false)
    private double amount;

    @ManyToOne
    private UserJpaModel user;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public UserJpaModel getUser() {
        return user;
    }

    public void setUser(UserJpaModel user) {
        this.user = user;
    }
}
