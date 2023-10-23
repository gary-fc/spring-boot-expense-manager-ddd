package com.garyfrancodev.ExpenseManagerApplication.use_cases.user;

import an.awesome.pipelinr.Command;
import com.garyfrancodev.ExpenseManagerApplication.dtos.user.CreateUserDto;
import org.springframework.stereotype.Component;

@Component
public class CreateUserHandler implements Command.Handler<CreateUserCommand, CreateUserDto>{

    @Override
    public CreateUserDto handle(CreateUserCommand createUserCommand) {

        return null;
    }
}
