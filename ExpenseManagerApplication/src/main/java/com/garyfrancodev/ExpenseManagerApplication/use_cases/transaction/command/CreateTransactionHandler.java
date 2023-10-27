package com.garyfrancodev.ExpenseManagerApplication.use_cases.transaction.command;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import com.garyfrancodev.ExpenseManagerApplication.dtos.transaction.CreateTransactionDto;
import com.garyfrancodev.ExpenseManagerDomain.events.transaction.CreatedTransaction;
import com.garyfrancodev.ExpenseManagerDomain.model.Transaction;
import com.garyfrancodev.ExpenseManagerDomain.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateTransactionHandler implements Command.Handler<CreateTransactionCommand, ResponseEntity<UUID>> {
    @Autowired
    private Pipeline pipeline;
    private final TransactionRepository _transactionRepository;

    public CreateTransactionHandler(TransactionRepository transactionRepository) {
        this._transactionRepository = transactionRepository;
    }

    @Override
    public ResponseEntity<UUID> handle(CreateTransactionCommand createTransactionCommand) {
        CreateTransactionDto transactionDto = createTransactionCommand.getTransactionDto();
        Transaction transaction = new Transaction(transactionDto.getAccountId(), transactionDto.getUserId(), transactionDto.getCategoryId(), transactionDto.getAmount(), transactionDto.getDate(), transactionDto.getTransactionDescription(), transactionDto.getTransactionType());

        _transactionRepository.create(transaction);
        new CreatedTransaction(transaction.getDate(), transaction.getAccountId(), transaction.getAmount(), transaction.getTransactionType()).send(pipeline);

        return ResponseEntity.ok(transaction.getId());
    }
}
