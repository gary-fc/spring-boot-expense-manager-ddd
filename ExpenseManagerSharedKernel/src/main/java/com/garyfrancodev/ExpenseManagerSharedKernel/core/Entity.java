package com.garyfrancodev.ExpenseManagerSharedKernel.core;

import java.util.ArrayList;
import java.util.Collection;
import java.util.UUID;

public abstract class Entity {
    public UUID id;
    private final Collection<DomainEvent> _domainEvents;
    public Collection<DomainEvent> domainEvents;

    public Entity() {
        this._domainEvents = new ArrayList<>();
    }

    public void addDomainEvent(DomainEvent event){
        this._domainEvents.add(event);
    }

    public void clearDomainEvents(){
        this._domainEvents.clear();
    }

    protected void checkRule(BusinessRule rule) throws BusinessRuleValidationException {
        if (rule == null){
            throw new IllegalArgumentException("Rule cannot be null");
        }

        if (!rule.isValid()){
            throw new BusinessRuleValidationException(rule);
        }
    }
}
