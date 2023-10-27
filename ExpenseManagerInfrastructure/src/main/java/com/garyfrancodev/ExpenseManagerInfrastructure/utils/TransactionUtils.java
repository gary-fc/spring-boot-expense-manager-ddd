package com.garyfrancodev.ExpenseManagerInfrastructure.utils;

import com.garyfrancodev.ExpenseManagerDomain.model.Account;
import com.garyfrancodev.ExpenseManagerDomain.model.Transaction;
import com.garyfrancodev.ExpenseManagerInfrastructure.model.AccountJpaModel;
import com.garyfrancodev.ExpenseManagerInfrastructure.model.TransactionJpaModel;

public class TransactionUtils {
    public static Transaction jpaModelToDomainModel(TransactionJpaModel transactionJpaModel) {
        return new Transaction(
                transactionJpaModel.getAccount().getId(),
                transactionJpaModel.getUser().getId(),
                transactionJpaModel.getCategory().getId(),
                transactionJpaModel.getAmount(),
                transactionJpaModel.getCreated_at(),
                transactionJpaModel.getDate(),
                transactionJpaModel.getTransactionDescription(),
                transactionJpaModel.getTransactionType(),
                transactionJpaModel.getId()
        );
    }
}
