package com.garyfrancodev.ExpenseManagerApplication.dtos.transaction;

import com.garyfrancodev.ExpenseManagerDomain.enums.TransactionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
public class TransactionDto {
    private UUID accountId;
    private UUID userId;
    private double amount;
    private Date date;
    private String transactionDescription;
    private TransactionType transactionType;
    private UUID id;
}
