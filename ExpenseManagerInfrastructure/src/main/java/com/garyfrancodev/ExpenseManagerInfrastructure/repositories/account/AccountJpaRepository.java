package com.garyfrancodev.ExpenseManagerInfrastructure.repositories.account;

import com.garyfrancodev.ExpenseManagerApplication.dtos.account.AccountDto;
import com.garyfrancodev.ExpenseManagerDomain.factories.account.AccountFactory;
import com.garyfrancodev.ExpenseManagerDomain.model.Account;
import com.garyfrancodev.ExpenseManagerDomain.repositories.AccountRepository;
import com.garyfrancodev.ExpenseManagerInfrastructure.model.AccountJpaModel;
import com.garyfrancodev.ExpenseManagerInfrastructure.model.UserJpaModel;
import com.garyfrancodev.ExpenseManagerInfrastructure.repositories.user.UserCrudRepository;
import com.garyfrancodev.ExpenseManagerInfrastructure.utils.AccountUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Repository
public class AccountJpaRepository implements AccountRepository {

    @Autowired
    private AccountCrudRepository _accountCrudRepository;
    @Autowired
    private UserCrudRepository _userCrudRepository;

    @Override
    public UUID create(Account account) {
        AccountJpaModel accountJpaModel = new AccountJpaModel();
        accountJpaModel.setId(account.getId());
        accountJpaModel.setAccountName(account.getAccountName());
        accountJpaModel.setDescription(account.getDescription());
        accountJpaModel.setAmount(account.getAmount());
        accountJpaModel.setUser(_userCrudRepository.findById(account.getUserId()).orElseThrow());
        return _accountCrudRepository.save(accountJpaModel).getId();
    }

    @Override
    public Double GetAmountTotalByUserId(UUID userId) {
        UserJpaModel userJpaModel = _userCrudRepository.findById(userId).orElseThrow();
        return _accountCrudRepository.total(userJpaModel);
    }

    @Override
    public List<Account> findAccountsByUserId(UUID userId) {
        System.out.println("userId");
        System.out.println(userId);
        UserJpaModel userJpaModel = _userCrudRepository.findById(userId).orElseThrow();
        List<AccountJpaModel> accountJpaModels = _accountCrudRepository.get(userJpaModel);
        return accountJpaModels.stream().map(AccountUtils::jpaModelToDomainModel).toList();
    }


}
