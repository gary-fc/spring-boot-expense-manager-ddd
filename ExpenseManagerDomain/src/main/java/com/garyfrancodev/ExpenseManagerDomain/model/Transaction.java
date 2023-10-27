package com.garyfrancodev.ExpenseManagerDomain.model;

import com.garyfrancodev.ExpenseManagerDomain.enums.TransactionType;
import com.garyfrancodev.ExpenseManagerSharedKernel.core.AggregateRoot;
import lombok.Getter;

import java.util.Date;
import java.util.UUID;

@Getter
public class Transaction extends AggregateRoot {
    private UUID accountId;
    private UUID userId;
    private UUID categoryId;
    private Double amount;
    private Date created_at;
    private Date date;
    private String transactionDescription;
    private TransactionType transactionType;

    public Transaction(UUID accountId, UUID userId,UUID categoryId, Double amount, Date date, String transactionDescription, TransactionType transactionType) {
        this.transactionDescription = transactionDescription;
        this.transactionType = transactionType;
        this.created_at = new Date();
        this.id = UUID.randomUUID();
        this.categoryId = categoryId;
        this.accountId = accountId;
        this.amount = amount;
        this.userId = userId;
        this.date = date;
    }

    public Transaction(UUID accountId, UUID userId,UUID categoryId, Double amount, Date created_at, Date date, String transactionDescription, TransactionType transactionType, UUID id) {
        this.transactionDescription = transactionDescription;
        this.transactionType = transactionType;
        this.created_at = created_at;
        this.categoryId = categoryId;
        this.accountId = accountId;
        this.amount = amount;
        this.userId = userId;
        this.date = date;
        this.id = id;
    }

    public void updateAmount(Double amount){
        this.amount = amount;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public UUID getUserId() {
        return userId;
    }

    public Double getAmount() {
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
