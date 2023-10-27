package com.garyfrancodev.ExpenseManagerApi.controller;

import an.awesome.pipelinr.Pipeline;
import com.garyfrancodev.ExpenseManagerApplication.dtos.transaction.CreateTransactionDto;
import com.garyfrancodev.ExpenseManagerApplication.dtos.transaction.TransactionDto;
import com.garyfrancodev.ExpenseManagerApplication.dtos.transaction.UpdateTransactionDto;
import com.garyfrancodev.ExpenseManagerApplication.use_cases.transaction.command.CreateTransactionCommand;
import com.garyfrancodev.ExpenseManagerApplication.use_cases.transaction.command.UpdateTransactionCommand;
import com.garyfrancodev.ExpenseManagerApplication.use_cases.transaction.queries.GetTransactionsByUserIdByPeriodQuery;
import com.garyfrancodev.ExpenseManagerApplication.use_cases.transaction.queries.GetTransactionsByUserIdQuery;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Tag(name = "Transaction Controller")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/transaction")
public class TransactionController {

    @Autowired
    Pipeline pipeline;

    @PostMapping()
    public ResponseEntity<UUID> create(@RequestBody CreateTransactionDto createTransactionDto) {
        CreateTransactionCommand createTransactionCommand = new CreateTransactionCommand(createTransactionDto);
        return createTransactionCommand.execute(pipeline);
    }

    @PutMapping()
    public ResponseEntity<UUID> update(@RequestBody UpdateTransactionDto updateTransactionDto) {
        UpdateTransactionCommand updateTransactionCommand = new UpdateTransactionCommand(updateTransactionDto);
        return updateTransactionCommand.execute(pipeline);
    }

    @GetMapping()
    public ResponseEntity<List<TransactionDto>> getTransactionsByUserId(@Parameter String userId) {
        GetTransactionsByUserIdQuery getTransactionsByUserIdQuery = new GetTransactionsByUserIdQuery(UUID.fromString(userId));
        return getTransactionsByUserIdQuery.execute(pipeline);
    }

    @GetMapping("/period")
    public ResponseEntity<List<TransactionDto>> getTransactionsByUserIdByPeriod(@Parameter String userId, @Parameter String startDate,@Parameter String endDate) {
        Date start = convertToDate(LocalDateTime.ofInstant(Instant.parse(startDate), ZoneId.systemDefault()));
        Date end = convertToDate(LocalDateTime.ofInstant(Instant.parse(endDate), ZoneId.systemDefault()));

        GetTransactionsByUserIdByPeriodQuery getTransactionsByUserIdByPeriodQuery = new GetTransactionsByUserIdByPeriodQuery(UUID.fromString(userId), start, end);
        return getTransactionsByUserIdByPeriodQuery.execute(pipeline);
    }

    private static Date convertToDate(LocalDateTime localDateTime) {
        Instant instant = localDateTime.atZone(ZoneId.systemDefault()).toInstant();
        return Date.from(instant);
    }
}
