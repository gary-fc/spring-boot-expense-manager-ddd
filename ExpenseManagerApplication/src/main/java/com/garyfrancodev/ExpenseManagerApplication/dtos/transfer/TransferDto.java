package com.garyfrancodev.ExpenseManagerApplication.dtos.transfer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
public class TransferDto {
    private UUID id;
    private UUID accountSend;
    private UUID accountReceives;
    private Double amount;
    private Date date;
    private UUID userId;
}
