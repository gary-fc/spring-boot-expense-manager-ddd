package com.garyfrancodev.ExpenseManagerApplication.use_cases.account.command;

import an.awesome.pipelinr.Command;
import com.garyfrancodev.ExpenseManagerDomain.enums.TransactionType;

import java.util.UUID;

public class UpdateAccountBalanceCommand implements Command<UUID> {
    private final UUID accountId;
    private final Double amount;
    private final TransactionType transactionType;
    private final Boolean isFromNewTransaction;

    public UpdateAccountBalanceCommand(UUID accountId, Double amount, TransactionType transactionType, Boolean isFromNewTransaction) {
        this.accountId = accountId;
        this.amount = amount;
        this.transactionType = transactionType;
        this.isFromNewTransaction = isFromNewTransaction;
    }

    public UUID getAccountId() {
        return accountId;
    }

    public Double getAmount() {
        return amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }

    public Boolean getFromNewTransaction() {
        return isFromNewTransaction;
    }
}
