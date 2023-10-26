package com.garyfrancodev.ExpenseManagerApplication.use_cases.account.queries;

import an.awesome.pipelinr.Command;
import com.garyfrancodev.ExpenseManagerApplication.dtos.account.AccountDto;

import java.util.List;
import java.util.UUID;

public class GetAccountsQuery implements Command<List<AccountDto>> {
    private UUID userId;

    public GetAccountsQuery(UUID userId) {
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }
}
