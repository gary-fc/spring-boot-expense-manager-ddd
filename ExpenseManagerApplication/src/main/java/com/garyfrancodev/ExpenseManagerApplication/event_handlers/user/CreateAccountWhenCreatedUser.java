package com.garyfrancodev.ExpenseManagerApplication.event_handlers.user;

import an.awesome.pipelinr.Notification;
import an.awesome.pipelinr.Pipeline;
import com.garyfrancodev.ExpenseManagerApplication.dtos.account.CreateAccountDto;
import com.garyfrancodev.ExpenseManagerApplication.use_cases.account.command.CreateAccountCommand;
import com.garyfrancodev.ExpenseManagerDomain.events.user.CreatedUserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateAccountWhenCreatedUser implements Notification.Handler<CreatedUserEvent> {

    @Autowired
    private Pipeline pipeline;

    @Override
    public void handle(CreatedUserEvent createdUserEvent) {
        CreateAccountDto createAccountDto = new CreateAccountDto("Bank Account", "", 0.00, createdUserEvent.getUserId());
        CreateAccountCommand createCategoryCommand = new CreateAccountCommand(createAccountDto);
        createCategoryCommand.execute(pipeline);
    }
}
