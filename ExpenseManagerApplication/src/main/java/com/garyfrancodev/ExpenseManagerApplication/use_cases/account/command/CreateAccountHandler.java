package com.garyfrancodev.ExpenseManagerApplication.use_cases.account.command;

import an.awesome.pipelinr.Command;
import com.garyfrancodev.ExpenseManagerApplication.dtos.account.CreateAccountDto;
import com.garyfrancodev.ExpenseManagerApplication.use_cases.account.command.CreateAccountCommand;
import com.garyfrancodev.ExpenseManagerDomain.factories.account.AccountFactory;
import com.garyfrancodev.ExpenseManagerDomain.factories.account.CreateAccount;
import com.garyfrancodev.ExpenseManagerDomain.model.Account;
import com.garyfrancodev.ExpenseManagerDomain.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateAccountHandler implements Command.Handler<CreateAccountCommand, UUID> {
    private final AccountFactory _accountFactory;
    private final AccountRepository _accountRepository;

    @Autowired
    public CreateAccountHandler(AccountRepository accountRepository) {
        this._accountRepository = accountRepository;
        this._accountFactory = new CreateAccount();
    }

    @Override
    public UUID handle(CreateAccountCommand createAccountCommand) {
        CreateAccountDto createAccountDto = createAccountCommand.getCreateAccountDto();
        Account account = _accountFactory.create(createAccountDto.getAccountName(), createAccountDto.getDescription(), createAccountDto.getAmount(), createAccountDto.getUserId());
        return _accountRepository.create(account);
    }
}
