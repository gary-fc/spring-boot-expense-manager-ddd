package com.garyfrancodev.ExpenseManagerDomain.repositories;

import com.garyfrancodev.ExpenseManagerDomain.model.Transaction;
import com.garyfrancodev.ExpenseManagerDomain.model.Transfer;

import java.util.List;
import java.util.UUID;

public interface TransferRepository {
    UUID create(Transfer transfer);
    List<Transfer> transferListByUserId(UUID userId);
}
