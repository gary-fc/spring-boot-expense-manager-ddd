package com.garyfrancodev.ExpenseManagerApplication.use_cases.transaction.queries;

import an.awesome.pipelinr.Command;
import com.garyfrancodev.ExpenseManagerApplication.dtos.transaction.TransactionDto;
import com.garyfrancodev.ExpenseManagerDomain.model.Transaction;
import com.garyfrancodev.ExpenseManagerDomain.repositories.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetTransactionsByUserIdHandler implements Command.Handler<GetTransactionsByUserIdQuery, ResponseEntity<List<TransactionDto>>> {

    private final TransactionRepository _transactionRepository;

    @Autowired
    public GetTransactionsByUserIdHandler(TransactionRepository transactionRepository) {
        this._transactionRepository = transactionRepository;
    }

    @Override
    public ResponseEntity<List<TransactionDto>> handle(GetTransactionsByUserIdQuery getTransactionsByUserIdQuery) {
        List<Transaction> transactionList = _transactionRepository.transactionListByUserId(getTransactionsByUserIdQuery.getUserId());

        return ResponseEntity.ok(transactionList.stream().map(transaction -> new TransactionDto(transaction.getAccountId(), transaction.getUserId(), transaction.getAmount(), transaction.getDate(), transaction.getTransactionDescription(), transaction.getTransactionType(), transaction.getId())).toList());
    }
}
