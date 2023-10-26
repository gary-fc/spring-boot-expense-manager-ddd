package com.garyfrancodev.ExpenseManagerApplication.use_cases.user;

import an.awesome.pipelinr.Command;
import com.garyfrancodev.ExpenseManagerApplication.dtos.user.CreateUserDto;

import java.util.UUID;

public class CreateUserCommand implements Command<UUID> {
    private final CreateUserDto createUserDto;

    public CreateUserCommand(CreateUserDto createUserDto) {
        this.createUserDto = createUserDto;
    }

    public CreateUserDto getCreateUserDto() {
        return createUserDto;
    }
}
