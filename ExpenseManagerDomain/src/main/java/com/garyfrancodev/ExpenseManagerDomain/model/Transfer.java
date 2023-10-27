package com.garyfrancodev.ExpenseManagerDomain.model;

import com.garyfrancodev.ExpenseManagerSharedKernel.core.AggregateRoot;

import java.util.Date;
import java.util.UUID;

public class Transfer extends AggregateRoot {
    private UUID accountSend;
    private UUID accountReceives;
    private Double amount;
    private Date date;
    private UUID userId;

    public Transfer(UUID accountSend, UUID accountReceives, Double amount, Date date, UUID userId) {
        this.accountReceives = accountReceives;
        this.accountSend = accountSend;
        this.id = UUID.randomUUID();
        this.amount = amount;
        this.userId = userId;
        this.date = date;
    }

    public Transfer(UUID accountSend, UUID accountReceives, Double amount, Date date, UUID userId, UUID id) {
        this.accountReceives = accountReceives;
        this.accountSend = accountSend;
        this.amount = amount;
        this.userId = userId;
        this.date = date;
        this.id = id;
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

    public Date getDate() {
        return date;
    }

    public UUID getUserId() {
        return userId;
    }
}
