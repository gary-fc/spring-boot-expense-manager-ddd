package com.garyfrancodev.ExpenseManagerDomain.model;

import com.garyfrancodev.ExpenseManagerDomain.enums.TransactionType;
import com.garyfrancodev.ExpenseManagerSharedKernel.core.AggregateRoot;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
public class Transaction extends AggregateRoot {
    private UUID accountId;
    private double amount;
    private Date created_at;
    private Date date;
    private String transactionDescription;
    private TransactionType transactionType;

    public Transaction(UUID accountId, double amount, Date date, String transactionDescription, TransactionType transactionType) {
        this.transactionDescription = transactionDescription;
        this.transactionType = transactionType;
        this.created_at = new Date();
        this.id = UUID.randomUUID();
        this.accountId = accountId;
        this.amount = amount;
        this.date = date;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public double getAmount() {
        return amount;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public Date getDate() {
        return date;
    }

    public String getTransactionDescription() {
        return transactionDescription;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }
}
