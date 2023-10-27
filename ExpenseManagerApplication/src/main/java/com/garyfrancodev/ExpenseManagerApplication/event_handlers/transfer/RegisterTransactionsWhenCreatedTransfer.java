package com.garyfrancodev.ExpenseManagerApplication.event_handlers.transfer;

import an.awesome.pipelinr.Notification;
import an.awesome.pipelinr.Pipeline;
import com.garyfrancodev.ExpenseManagerApplication.dtos.transaction.CreateTransactionDto;
import com.garyfrancodev.ExpenseManagerApplication.use_cases.transaction.command.CreateTransactionCommand;
import com.garyfrancodev.ExpenseManagerDomain.enums.CategoryType;
import com.garyfrancodev.ExpenseManagerDomain.enums.TransactionType;
import com.garyfrancodev.ExpenseManagerDomain.events.transfer.CreatedTransfer;
import com.garyfrancodev.ExpenseManagerDomain.model.Category;
import com.garyfrancodev.ExpenseManagerDomain.repositories.CategoryRepository;
import com.garyfrancodev.ExpenseManagerSharedKernel.core.BusinessRuleValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class RegisterTransactionsWhenCreatedTransfer implements Notification.Handler<CreatedTransfer> {
    @Autowired
    private Pipeline pipeline;

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    public void handle(CreatedTransfer createdTransfer) {
        Category category = null;
        try {
            category = categoryRepository.getCategoryDefaultByUserByCategoryType(createdTransfer.getUserId(), "DefaultExpense");
        } catch (BusinessRuleValidationException e) {
            throw new RuntimeException(e);
        }
        CreateTransactionDto transactionAccountSend = buildCreateTransactionDto(createdTransfer, createdTransfer.getAccountSend(), TransactionType.EXPENSE_TRANSFER, category);

        CreateTransactionCommand createTransactionCommand = new CreateTransactionCommand(transactionAccountSend);
        createTransactionCommand.execute(pipeline);

        try {
            category = categoryRepository.getCategoryDefaultByUserByCategoryType(createdTransfer.getUserId(), "DefaultIncome");
        } catch (BusinessRuleValidationException e) {
            throw new RuntimeException(e);
        }
        CreateTransactionDto transactionAccountReceives = buildCreateTransactionDto(createdTransfer, createdTransfer.getAccountReceives(), TransactionType.INCOME_TRANSFER, category);

        CreateTransactionCommand createTransactionCommandReceives = new CreateTransactionCommand(transactionAccountReceives);
        createTransactionCommandReceives.execute(pipeline);
    }


    private CreateTransactionDto buildCreateTransactionDto(CreatedTransfer createdTransfer, UUID accountId, TransactionType transactionType, Category category) {
        CreateTransactionDto createTransactionDto = new CreateTransactionDto();

        createTransactionDto.setTransactionDescription(createdTransfer.getDescription());
        createTransactionDto.setAmount(createdTransfer.getAmount());
        createTransactionDto.setUserId(createdTransfer.getUserId());
        createTransactionDto.setCategoryId(category.getId());
        createTransactionDto.setTransactionType(transactionType);
        createTransactionDto.setAccountId(accountId);
        createTransactionDto.setDate(new Date());
        return createTransactionDto;
    }
}
