package com.garyfrancodev.ExpenseManagerApplication.dtos.transfer;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.UUID;

@Setter
@Getter
@AllArgsConstructor
public class CreateTransferDto {
    private UUID accountSend;
    private UUID accountReceives;
    private Double amount;
    private Date date;
    private UUID userId;
}
