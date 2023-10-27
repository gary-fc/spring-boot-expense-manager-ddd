package com.garyfrancodev.ExpenseManagerApi.controller;

import an.awesome.pipelinr.Pipeline;
import com.garyfrancodev.ExpenseManagerApplication.dtos.transaction.TransactionDto;
import com.garyfrancodev.ExpenseManagerApplication.dtos.transfer.CreateTransferDto;
import com.garyfrancodev.ExpenseManagerApplication.dtos.transfer.TransferDto;
import com.garyfrancodev.ExpenseManagerApplication.use_cases.transfer.command.CreateTransferCommand;
import com.garyfrancodev.ExpenseManagerApplication.use_cases.transfer.queries.GetTransfersByUserIdQuery;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Tag(name = "Transfer Controller")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/transfer")
public class TransferController {
    @Autowired
    Pipeline pipeline;
    @GetMapping()
    public ResponseEntity<List<TransferDto>> getTransferByUserId(@Parameter String userId) {
        GetTransfersByUserIdQuery getTransfersByUserIdQuery = new GetTransfersByUserIdQuery(UUID.fromString(userId));
        return getTransfersByUserIdQuery.execute(pipeline);
    }

    @PostMapping()
    public ResponseEntity<UUID> createTransfer(@RequestBody CreateTransferDto createTransferDto){
        CreateTransferCommand transferCommand = new CreateTransferCommand(createTransferDto);
        return transferCommand.execute(pipeline);
    }
}
