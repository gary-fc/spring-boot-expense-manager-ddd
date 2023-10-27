package com.garyfrancodev.ExpenseManagerDomain.events.user;

import an.awesome.pipelinr.Notification;
import com.garyfrancodev.ExpenseManagerSharedKernel.core.DomainEvent;

import java.util.Date;
import java.util.UUID;

public class CreatedUserEvent extends DomainEvent implements Notification {
    private final UUID userId;

    public CreatedUserEvent(UUID userId, Date date) {
        super(date);
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }
}
