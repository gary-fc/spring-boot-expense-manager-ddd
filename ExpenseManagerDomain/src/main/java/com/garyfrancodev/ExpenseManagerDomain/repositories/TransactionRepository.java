package com.garyfrancodev.ExpenseManagerDomain.repositories;

import com.garyfrancodev.ExpenseManagerDomain.model.Transaction;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface TransactionRepository {
    UUID create(Transaction transaction);

    UUID update(Transaction transaction);
    Transaction get(UUID transactionId);

    UUID delete(UUID id);

    List<Transaction> transactionListByUserId(UUID userId);
    List<Transaction> transactionListByUserIdByPeriod(UUID userId, Date startDate, Date endDate);
    List<Transaction> transactionListByAccountId(UUID accountId);
}
