package com.garyfrancodev.ExpenseManagerSharedKernel.core;

import java.util.Date;
import java.util.UUID;

public abstract class DomainEvent {
    public Date occurredOn;
    public UUID id;
    public boolean consumed;

    public DomainEvent(Date occurredOn) {
        this.occurredOn = occurredOn;
        this.id = UUID.randomUUID();
        this.consumed = false;
    }

    public void markAsConsumed(){
        this.consumed= true;
    }
}
