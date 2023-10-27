package com.garyfrancodev.ExpenseManagerApplication.use_cases.account.command;

import an.awesome.pipelinr.Command;
import com.garyfrancodev.ExpenseManagerDomain.enums.TransactionType;
import com.garyfrancodev.ExpenseManagerDomain.model.Account;
import com.garyfrancodev.ExpenseManagerDomain.repositories.AccountRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UpdateAccountBalanceHandler implements Command.Handler<UpdateAccountBalanceCommand, UUID> {
    private final AccountRepository _accountRepository;

    public UpdateAccountBalanceHandler(AccountRepository accountRepository) {
        this._accountRepository = accountRepository;
    }

    @Override
    public UUID handle(UpdateAccountBalanceCommand updateAccountBalanceCommand) {
        Account account = _accountRepository.getAccountById(updateAccountBalanceCommand.getAccountId());
        TransactionType transactionType = updateAccountBalanceCommand.getTransactionType();

        if (updateAccountBalanceCommand.getFromNewTransaction()) {
            if (transactionType == TransactionType.EXPENSE || transactionType == TransactionType.EXPENSE_TRANSFER) {
                account.decreaseAmount(updateAccountBalanceCommand.getAmount());
            }

            if (transactionType == TransactionType.INCOME || transactionType == TransactionType.INCOME_TRANSFER) {
                account.increaseAmount(updateAccountBalanceCommand.getAmount());
            }
        } else {
            double difference = updateAccountBalanceCommand.getAmount();

            if (difference > 0 && transactionType == TransactionType.INCOME || difference < 0 && transactionType == TransactionType.EXPENSE){
                account.decreaseAmount(Math.abs(difference));
            }else {
                account.increaseAmount(Math.abs(difference));
            }
        }

        return _accountRepository.update(account);
    }
}
