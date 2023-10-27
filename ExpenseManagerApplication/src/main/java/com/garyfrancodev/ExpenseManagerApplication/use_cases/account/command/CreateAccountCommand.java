package com.garyfrancodev.ExpenseManagerApplication.use_cases.account.command;

import an.awesome.pipelinr.Command;
import com.garyfrancodev.ExpenseManagerApplication.dtos.account.CreateAccountDto;
import org.springframework.http.ResponseEntity;

import java.util.UUID;

public class CreateAccountCommand implements Command<ResponseEntity<UUID>> {
    private final CreateAccountDto createAccountDto;

    public CreateAccountCommand(CreateAccountDto createAccountDto) {
        this.createAccountDto = createAccountDto;
    }

    public CreateAccountDto getCreateAccountDto() {
        return createAccountDto;
    }
}
