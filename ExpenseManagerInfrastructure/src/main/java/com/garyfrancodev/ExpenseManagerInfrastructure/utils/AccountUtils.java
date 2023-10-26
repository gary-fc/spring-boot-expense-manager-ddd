package com.garyfrancodev.ExpenseManagerInfrastructure.utils;

import com.garyfrancodev.ExpenseManagerDomain.model.Account;
import com.garyfrancodev.ExpenseManagerInfrastructure.model.AccountJpaModel;


public class AccountUtils {
    public static Account jpaModelToDomainModel(AccountJpaModel accountJpaModel) {
        return new Account(
                accountJpaModel.getAccountName(),
                accountJpaModel.getDescription(),
                accountJpaModel.getAmount(),
                accountJpaModel.getUser().getId(),
                accountJpaModel.getId()
        );
    }
}
