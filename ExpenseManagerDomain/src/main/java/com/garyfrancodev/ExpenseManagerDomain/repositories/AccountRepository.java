package com.garyfrancodev.ExpenseManagerDomain.repositories;

import com.garyfrancodev.ExpenseManagerDomain.model.Account;

import java.util.List;
import java.util.UUID;

public interface AccountRepository {
    UUID create(Account account);

    Double GetAmountTotalByUserId(UUID userId);

    List<Account> findAccountsByUserId(UUID userId);

}
