package com.garyfrancodev.ExpenseManagerApplication.use_cases.account.queries;

import an.awesome.pipelinr.Command;

import java.util.UUID;

public class GetAmountTotalQuery implements Command<Double> {
    private UUID userId;

    public GetAmountTotalQuery(UUID userId) {
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }
}
