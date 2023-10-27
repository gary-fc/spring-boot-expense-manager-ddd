package com.garyfrancodev.ExpenseManagerApplication.use_cases.account.command;

import an.awesome.pipelinr.Command;
import com.garyfrancodev.ExpenseManagerApplication.dtos.account.CreateAccountDto;
import com.garyfrancodev.ExpenseManagerDomain.model.Account;
import com.garyfrancodev.ExpenseManagerDomain.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateAccountHandler implements Command.Handler<CreateAccountCommand, ResponseEntity<UUID>> {
    private final AccountRepository _accountRepository;

    @Autowired
    public CreateAccountHandler(AccountRepository accountRepository) {
        this._accountRepository = accountRepository;
    }

    @Override
    public ResponseEntity<UUID> handle(CreateAccountCommand createAccountCommand) {
        CreateAccountDto createAccountDto = createAccountCommand.getCreateAccountDto();
        Account account = new Account(createAccountDto.getAccountName(), createAccountDto.getDescription(), createAccountDto.getAmount(), createAccountDto.getUserId());
        return _accountRepository.create(account);
    }
}
