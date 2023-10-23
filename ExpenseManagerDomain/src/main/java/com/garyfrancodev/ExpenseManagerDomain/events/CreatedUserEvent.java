package com.garyfrancodev.ExpenseManagerDomain.events;

import com.garyfrancodev.ExpenseManagerDomain.model.User;
import com.garyfrancodev.ExpenseManagerSharedKernel.core.DomainEvent;

import java.util.Date;

public class CreatedUserEvent extends DomainEvent {
    public CreatedUserEvent(User user) {
        super(user.get);
    }
}
