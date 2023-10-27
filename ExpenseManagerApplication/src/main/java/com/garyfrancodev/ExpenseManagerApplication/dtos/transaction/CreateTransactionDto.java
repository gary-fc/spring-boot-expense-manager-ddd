package com.garyfrancodev.ExpenseManagerApplication.dtos.transaction;

import com.garyfrancodev.ExpenseManagerDomain.enums.TransactionType;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@Data
public class CreateTransactionDto {
    private UUID accountId;
    private UUID userId;
    private UUID categoryId;
    private double amount;
    private Date date;
    private String transactionDescription;
    private TransactionType transactionType;
    private UUID id;
}
