package com.garyfrancodev.ExpenseManagerApplication.event_handlers.transaction;

import an.awesome.pipelinr.Notification;
import an.awesome.pipelinr.Pipeline;
import com.garyfrancodev.ExpenseManagerApplication.use_cases.account.command.UpdateAccountBalanceCommand;
import com.garyfrancodev.ExpenseManagerDomain.events.transaction.UpdatedTransaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateAccountBalanceWhenUpdatedTransaction implements Notification.Handler<UpdatedTransaction> {

    @Autowired
    private Pipeline pipeline;

    @Override
    public void handle(UpdatedTransaction updatedTransaction) {
        UpdateAccountBalanceCommand updateAccountBalanceCommand = new UpdateAccountBalanceCommand(updatedTransaction.getAccountId(), updatedTransaction.getNewAmount(), updatedTransaction.getTransactionType(), false);
        updateAccountBalanceCommand.execute(pipeline);
    }
}
