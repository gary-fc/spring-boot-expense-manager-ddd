package com.garyfrancodev.ExpenseManagerApplication.use_cases.transfer.queries;

import an.awesome.pipelinr.Command;
import com.garyfrancodev.ExpenseManagerApplication.dtos.transfer.TransferDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public class GetTransfersByUserIdQuery implements Command<ResponseEntity<List<TransferDto>>> {
    private final UUID userId;

    public GetTransfersByUserIdQuery(UUID userId) {
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }
}
