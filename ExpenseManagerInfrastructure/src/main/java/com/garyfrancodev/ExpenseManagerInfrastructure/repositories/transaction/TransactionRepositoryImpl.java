package com.garyfrancodev.ExpenseManagerInfrastructure.repositories.transaction;

import com.garyfrancodev.ExpenseManagerDomain.model.Transaction;
import com.garyfrancodev.ExpenseManagerDomain.repositories.TransactionRepository;
import com.garyfrancodev.ExpenseManagerInfrastructure.model.AccountJpaModel;
import com.garyfrancodev.ExpenseManagerInfrastructure.model.CategoryJpaModel;
import com.garyfrancodev.ExpenseManagerInfrastructure.model.TransactionJpaModel;
import com.garyfrancodev.ExpenseManagerInfrastructure.model.UserJpaModel;
import com.garyfrancodev.ExpenseManagerInfrastructure.repositories.account.AccountJpaRepository;
import com.garyfrancodev.ExpenseManagerInfrastructure.repositories.category.CategoryJpaRepository;
import com.garyfrancodev.ExpenseManagerInfrastructure.repositories.user.UserJpaRepository;
import com.garyfrancodev.ExpenseManagerInfrastructure.utils.TransactionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class TransactionRepositoryImpl implements TransactionRepository {
    @Autowired
    private UserJpaRepository _userJpaRepository;
    @Autowired
    private AccountJpaRepository accountJpaRepository;
    @Autowired
    private TransactionJpaRepository transactionJpaRepository;
    @Autowired
    private CategoryJpaRepository categoryJpaRepository;

    @Override
    public UUID create(Transaction transaction) {
        AccountJpaModel accountJpaModel = accountJpaRepository.findById(transaction.getAccountId()).orElseThrow();
        UserJpaModel userJpaModel = _userJpaRepository.findById(transaction.getUserId()).orElseThrow();
        CategoryJpaModel categoryJpaModel = categoryJpaRepository.findById(transaction.getCategoryId()).orElseThrow();

        TransactionJpaModel transactionJpaModel = new TransactionJpaModel();
        transactionJpaModel.setTransactionType(transaction.getTransactionType());
        transactionJpaModel.setTransactionDescription(transaction.getTransactionDescription());
        transactionJpaModel.setCreated_at(transaction.getCreated_at());
        transactionJpaModel.setAmount(transaction.getAmount());
        transactionJpaModel.setId(transaction.getId());
        transactionJpaModel.setAccount(accountJpaModel);
        transactionJpaModel.setDate(transaction.getDate());
        transactionJpaModel.setCategory(categoryJpaModel);
        transactionJpaModel.setUser(userJpaModel);

        return transactionJpaRepository.save(transactionJpaModel).getId();
    }

    @Override
    public UUID update(Transaction transaction) {
        TransactionJpaModel transactionJpaModel = transactionJpaRepository.findById(transaction.getId()).orElseThrow();
        transactionJpaModel.setTransactionDescription(transaction.getTransactionDescription());
        transactionJpaModel.setAmount(transaction.getAmount());
        transactionJpaModel.setDate(transaction.getDate());

        return transactionJpaRepository.save(transactionJpaModel).getId();
    }

    @Override
    public Transaction get(UUID transactionId) {
        TransactionJpaModel transactionJpaModel = transactionJpaRepository.findById(transactionId).orElseThrow();
        return TransactionUtils.jpaModelToDomainModel(transactionJpaModel);
    }

    @Override
    public UUID delete(UUID id) {
        return null;
    }

    @Override
    public List<Transaction> transactionListByUserId(UUID userId) {
        List<TransactionJpaModel> transactionJpaList = transactionJpaRepository.findAllByUser_Id(userId);
        return transactionJpaList.stream().map(TransactionUtils::jpaModelToDomainModel).toList();
    }

    @Override
    public List<Transaction> transactionListByUserIdByPeriod(UUID userId, Date startDate, Date endDate) {
        UserJpaModel userJpaModel = _userJpaRepository.findById(userId).orElseThrow();
        List<TransactionJpaModel> transactionJpaList = transactionJpaRepository.findAllByUser_IdByDateBetween(userJpaModel, startDate, endDate);
        return transactionJpaList.stream().map(TransactionUtils::jpaModelToDomainModel).toList();
    }

    @Override
    public List<Transaction> transactionListByAccountId(UUID accountId) {
        return null;
    }
}
