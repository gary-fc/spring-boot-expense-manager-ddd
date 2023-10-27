package com.garyfrancodev.ExpenseManagerInfrastructure.repositories.transfer;

import com.garyfrancodev.ExpenseManagerDomain.model.Transfer;
import com.garyfrancodev.ExpenseManagerDomain.repositories.TransferRepository;
import com.garyfrancodev.ExpenseManagerInfrastructure.model.AccountJpaModel;
import com.garyfrancodev.ExpenseManagerInfrastructure.model.TransactionJpaModel;
import com.garyfrancodev.ExpenseManagerInfrastructure.model.TransferJpaModel;
import com.garyfrancodev.ExpenseManagerInfrastructure.model.UserJpaModel;
import com.garyfrancodev.ExpenseManagerInfrastructure.repositories.account.AccountJpaRepository;
import com.garyfrancodev.ExpenseManagerInfrastructure.repositories.user.UserJpaRepository;
import com.garyfrancodev.ExpenseManagerInfrastructure.utils.TransactionUtils;
import com.garyfrancodev.ExpenseManagerInfrastructure.utils.TransferUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;


@Repository
public class TransferRepositoryImpl implements TransferRepository {
    @Autowired
    private UserJpaRepository _userJpaRepository;
    @Autowired
    private AccountJpaRepository accountJpaRepository;
    @Autowired
    private TransferJpaRepository transferJpaRepository;

    @Override
    public UUID create(Transfer transfer) {
        AccountJpaModel accountSend = accountJpaRepository.findById(transfer.getAccountSend()).orElseThrow();
        AccountJpaModel accountReceives = accountJpaRepository.findById(transfer.getAccountReceives()).orElseThrow();
        UserJpaModel userJpaModel = _userJpaRepository.findById(transfer.getUserId()).orElseThrow();

        TransferJpaModel transferJpaModel = TransferUtils.domainModelToJpa(transfer);

        transferJpaModel.setUser(userJpaModel);
        transferJpaModel.setAccountSend(accountSend);
        transferJpaModel.setAccountReceives(accountReceives);

        return transferJpaRepository.save(transferJpaModel).getId();
    }

    @Override
    public List<Transfer> transferListByUserId(UUID userId) {
        List<TransferJpaModel> transferJpaList = transferJpaRepository.findAllByUser_Id(userId);
        return transferJpaList.stream().map(TransferUtils::jpaModelToDomainModel).toList();
    }
}
