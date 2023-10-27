package com.garyfrancodev.ExpenseManagerInfrastructure.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Setter
@Getter
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

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account", cascade = CascadeType.ALL)
    private List<TransactionJpaModel> transactions;

    public AccountJpaModel() {
        transactions = new ArrayList<>();
    }
}
