package com.garyfrancodev.ExpenseManagerDomain.events.transfer;

import an.awesome.pipelinr.Notification;
import com.garyfrancodev.ExpenseManagerSharedKernel.core.DomainEvent;

import java.util.Date;
import java.util.UUID;

public class CreatedTransfer extends DomainEvent implements Notification {
    private final UUID accountSend;
    private final UUID accountReceives;
    private final Double amount;
    private final UUID userId;
    private final String description;
    private final UUID categoryId;

    public CreatedTransfer(Date occurredOn, UUID accountSend, UUID accountReceives, Double amount,UUID userId, String description, UUID categoryId) {
        super(occurredOn);
        this.accountSend = accountSend;
        this.accountReceives = accountReceives;
        this.amount = amount;
        this.userId = userId;
        this.description = description;
        this.categoryId = categoryId;
    }

    public UUID getAccountSend() {
        return accountSend;
    }

    public UUID getAccountReceives() {
        return accountReceives;
    }

    public Double getAmount() {
        return amount;
    }

    public UUID getUserId() {
        return userId;
    }

    public String getDescription() {
        return description;
    }

    public UUID getCategoryId() {
        return categoryId;
    }
}
