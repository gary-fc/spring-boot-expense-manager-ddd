package com.garyfrancodev.ExpenseManagerDomain.events;

import an.awesome.pipelinr.Notification;
import com.garyfrancodev.ExpenseManagerDomain.model.User;
import com.garyfrancodev.ExpenseManagerSharedKernel.core.DomainEvent;

public class CreatedUserEvent extends DomainEvent implements Notification {
    private User user;

    public CreatedUserEvent(User user) {
        super(user.getDate());
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
