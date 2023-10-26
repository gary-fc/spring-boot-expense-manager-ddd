package com.garyfrancodev.ExpenseManagerApi.controller;


import an.awesome.pipelinr.Pipeline;
import com.garyfrancodev.ExpenseManagerApplication.dtos.account.AccountDto;
import com.garyfrancodev.ExpenseManagerApplication.dtos.account.CreateAccountDto;
import com.garyfrancodev.ExpenseManagerApplication.use_cases.account.queries.GetAccountsQuery;
import com.garyfrancodev.ExpenseManagerApplication.use_cases.account.queries.GetAmountTotalQuery;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Account Controller")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/account")
public class AccountController {
    @Autowired
    private Pipeline pipeline;

    @PostMapping()
    public UUID create(@RequestBody CreateAccountDto createAccountDto) {
        return UUID.randomUUID();
    }

    @GetMapping("GetAmountTotal")
    public Double getAmountTotal(@Parameter String userId) {
        GetAmountTotalQuery getAmountTotalQuery = new GetAmountTotalQuery(UUID.fromString(userId));
        return getAmountTotalQuery.execute(pipeline);
    }

    @GetMapping("GetAccounts")
    public List<AccountDto> getAccounts(@Parameter String userId) {
        GetAccountsQuery getAccountsQuery = new GetAccountsQuery(UUID.fromString(userId));
        return getAccountsQuery.execute(pipeline);
    }
}
