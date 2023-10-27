package com.garyfrancodev.ExpenseManagerInfrastructure.model;

import com.garyfrancodev.ExpenseManagerDomain.enums.TransactionType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@Entity
@Table(name = "transactions")
public class TransactionJpaModel {
    @Id
    @Column(nullable = false)
    private UUID id;

    @Column(nullable = false)
    private double amount;

    @Column(nullable = false)
    private Date created_at;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private String transactionDescription;

    @Column(nullable = false)
    private TransactionType transactionType;

    @ManyToOne(fetch = FetchType.LAZY)
    private AccountJpaModel account;

    @ManyToOne(fetch = FetchType.LAZY)
    private UserJpaModel user;

    @ManyToOne(fetch = FetchType.LAZY)
    private CategoryJpaModel category;
}
