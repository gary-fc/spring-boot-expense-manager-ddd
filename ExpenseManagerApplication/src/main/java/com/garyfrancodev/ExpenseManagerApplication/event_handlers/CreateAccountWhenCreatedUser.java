package com.garyfrancodev.ExpenseManagerApplication.event_handlers;

import an.awesome.pipelinr.Notification;
import an.awesome.pipelinr.NotificationHandlers;
import com.garyfrancodev.ExpenseManagerDomain.events.CreatedUserEvent;

public class CreateAccountWhenCreatedUser implements Notification.Handler<CreatedUserEvent> {
    @Override
    public void handle(CreatedUserEvent createdUserEvent) {
        System.out.println("asdasd");
    }
}
