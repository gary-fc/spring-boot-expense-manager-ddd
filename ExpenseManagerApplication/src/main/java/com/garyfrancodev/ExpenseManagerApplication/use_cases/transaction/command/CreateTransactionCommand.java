package com.garyfrancodev.ExpenseManagerApplication.use_cases.transaction.command;

import an.awesome.pipelinr.Command;
import com.garyfrancodev.ExpenseManagerApplication.dtos.transaction.CreateTransactionDto;
import com.garyfrancodev.ExpenseManagerApplication.dtos.transaction.TransactionDto;
import com.garyfrancodev.ExpenseManagerDomain.repositories.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.UUID;

public class CreateTransactionCommand implements Command<ResponseEntity<UUID>> {
    private final CreateTransactionDto transactionDto;

    public CreateTransactionCommand(CreateTransactionDto transactionDto) {
        this.transactionDto = transactionDto;
    }

    public CreateTransactionDto getTransactionDto() {
        return transactionDto;
    }
}
