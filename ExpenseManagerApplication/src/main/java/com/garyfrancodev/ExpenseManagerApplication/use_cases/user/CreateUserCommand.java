package com.garyfrancodev.ExpenseManagerApplication.use_cases.user;

import an.awesome.pipelinr.Command;
import com.garyfrancodev.ExpenseManagerApplication.dtos.user.CreateUserDto;

import java.util.UUID;

public class CreateUserCommand implements Command<UUID> {
    CreateUserDto createUserDto;

    public CreateUserCommand(CreateUserDto createUserDto) {
        this.createUserDto = createUserDto;
    }
}
