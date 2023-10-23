package com.garyfrancodev.ExpenseManagerApplication.use_cases.user;

import an.awesome.pipelinr.Command;
import com.garyfrancodev.ExpenseManagerApplication.dtos.user.CreateUserDto;

public class CreateUserCommand implements Command<CreateUserDto> {
    CreateUserDto createUserDto;

    public CreateUserCommand(CreateUserDto createUserDto) {
        this.createUserDto = createUserDto;
    }
}
