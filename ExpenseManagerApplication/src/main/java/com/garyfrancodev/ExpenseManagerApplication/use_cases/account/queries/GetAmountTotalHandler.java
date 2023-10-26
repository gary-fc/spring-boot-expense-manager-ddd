package com.garyfrancodev.ExpenseManagerApplication.use_cases.account.queries;

import an.awesome.pipelinr.Command;
import com.garyfrancodev.ExpenseManagerDomain.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAmountTotalHandler implements Command.Handler<GetAmountTotalQuery, Double> {
    private final AccountRepository _accountRepository;

    @Autowired
    public GetAmountTotalHandler(AccountRepository accountRepository) {
        this._accountRepository = accountRepository;
    }

    @Override
    public Double handle(GetAmountTotalQuery getAmountTotalQuery) {
        System.out.println("getAmountTotalQuery.getUserId()");
        System.out.println(getAmountTotalQuery.getUserId());
        return _accountRepository.GetAmountTotalByUserId(getAmountTotalQuery.getUserId());
    }
}
