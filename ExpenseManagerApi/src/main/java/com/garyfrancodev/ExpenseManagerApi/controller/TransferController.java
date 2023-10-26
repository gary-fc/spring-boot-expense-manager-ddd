package com.garyfrancodev.ExpenseManagerApi.controller;

import com.garyfrancodev.ExpenseManagerApplication.dtos.transaction.TransactionDto;
import com.garyfrancodev.ExpenseManagerApplication.dtos.transfer.TransferDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "Transfer Controller")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/transfer")
public class TransferController {
    @GetMapping()
    public ResponseEntity<List<TransferDto>> index() {
        return null;
    }
}
