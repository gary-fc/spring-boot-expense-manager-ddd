package com.garyfrancodev.ExpenseManagerApplication.use_cases.transaction.queries;

import an.awesome.pipelinr.Command;
import com.garyfrancodev.ExpenseManagerApplication.dtos.transaction.TransactionDto;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public class GetTransactionsByUserIdByPeriodQuery implements Command<ResponseEntity<List<TransactionDto>>> {
    private final UUID userId;
    private final Date startDate;
    private final Date endDate;

    public GetTransactionsByUserIdByPeriodQuery(UUID userId, Date startDate, Date endDate) {
        this.userId = userId;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public UUID getUserId() {
        return userId;
    }

    public Date getStartDate() {
        return startDate;
    }

    public Date getEndDate() {
        return endDate;
    }
}
