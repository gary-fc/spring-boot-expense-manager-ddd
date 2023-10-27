package com.garyfrancodev.ExpenseManagerApplication.use_cases.transaction.command;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import com.garyfrancodev.ExpenseManagerApplication.dtos.transaction.UpdateTransactionDto;
import com.garyfrancodev.ExpenseManagerDomain.events.transaction.UpdatedTransaction;
import com.garyfrancodev.ExpenseManagerDomain.model.Transaction;
import com.garyfrancodev.ExpenseManagerDomain.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class UpdateTransactionHandler implements Command.Handler<UpdateTransactionCommand, ResponseEntity<UUID>> {
    @Autowired
    private Pipeline pipeline;
    private final TransactionRepository _transactionRepository;

    public UpdateTransactionHandler(TransactionRepository transactionRepository) {
        this._transactionRepository = transactionRepository;
    }

    @Override
    public ResponseEntity<UUID> handle(UpdateTransactionCommand updateTransactionCommand) {
        UpdateTransactionDto updateTransactionDto = updateTransactionCommand.getUpdateTransactionDto();
        Transaction transaction = this._transactionRepository.get(updateTransactionDto.getId());

        Double difference = transaction.getAmount() - updateTransactionDto.getAmount();

        transaction.updateAmount(updateTransactionDto.getAmount());

        this._transactionRepository.update(transaction);
        new UpdatedTransaction(transaction.getDate(),transaction.getAccountId(), difference, transaction.getTransactionType()).send(pipeline);

        return ResponseEntity.ok(transaction.getId());
    }
}
