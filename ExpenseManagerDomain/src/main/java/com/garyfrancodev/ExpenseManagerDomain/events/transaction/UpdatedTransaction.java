package com.garyfrancodev.ExpenseManagerDomain.events.transaction;

import an.awesome.pipelinr.Notification;
import com.garyfrancodev.ExpenseManagerDomain.enums.TransactionType;
import com.garyfrancodev.ExpenseManagerSharedKernel.core.DomainEvent;

import java.util.Date;
import java.util.UUID;

public class UpdatedTransaction extends DomainEvent implements Notification {
    private UUID accountId;
    private Double newAmount;
    private TransactionType transactionType;

    public UpdatedTransaction(Date occurredOn, UUID accountId, Double newAmount, TransactionType transactionType) {
        super(occurredOn);
        this.accountId = accountId;
        this.newAmount = newAmount;
        this.transactionType = transactionType;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public Double getNewAmount() {
        return newAmount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }
}
