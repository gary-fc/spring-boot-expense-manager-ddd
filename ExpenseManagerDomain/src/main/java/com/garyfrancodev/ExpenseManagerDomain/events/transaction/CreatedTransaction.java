package com.garyfrancodev.ExpenseManagerDomain.events.transaction;

import an.awesome.pipelinr.Notification;
import com.garyfrancodev.ExpenseManagerDomain.enums.TransactionType;
import com.garyfrancodev.ExpenseManagerSharedKernel.core.DomainEvent;

import java.util.Date;
import java.util.UUID;

public class CreatedTransaction extends DomainEvent implements Notification {
    private UUID accountId;
    private Double amount;
    private TransactionType transactionType;


    public CreatedTransaction(Date occurredOn, UUID accountId, Double amount, TransactionType transactionType) {
        super(occurredOn);
        this.transactionType = transactionType;
        this.accountId = accountId;
        this.amount = amount;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public Double getAmount() {
        return amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }
}
