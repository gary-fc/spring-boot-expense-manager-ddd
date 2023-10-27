package com.garyfrancodev.ExpenseManagerApplication.use_cases.account.queries;

import an.awesome.pipelinr.Command;
import com.garyfrancodev.ExpenseManagerApplication.dtos.account.AccountDto;
import com.garyfrancodev.ExpenseManagerDomain.model.Account;
import com.garyfrancodev.ExpenseManagerDomain.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class GetAccountsHandler implements Command.Handler<GetAccountsQuery, List<AccountDto>> {

    private final AccountRepository _accountRepository;

    @Autowired
    public GetAccountsHandler(AccountRepository accountRepository) {
        this._accountRepository = accountRepository;
    }

    @Override
    public List<AccountDto> handle(GetAccountsQuery getAccountsQuery) {
        List<Account> accounts = _accountRepository.findAccountsByUserId(getAccountsQuery.getUserId());
        System.out.println("accounts.get(0).getUserId()");
        System.out.println(accounts.get(0).getUserId());
        List<AccountDto> accountDtos = accounts.stream().map(account -> new AccountDto(account.getAccountName(), account.getDescription(), account.getAmount(), account.getUserId(), account.getId())).toList();
        System.out.println("asdasd");
        System.out.println(accountDtos.get(0).getUserId());
        return accounts.stream().map(account -> new AccountDto(account.getAccountName(), account.getDescription(), account.getAmount(), account.getUserId(), account.getId())).toList();
    }
}
