package com.garyfrancodev.ExpenseManagerInfrastructure.repositories.transfer;

import com.garyfrancodev.ExpenseManagerInfrastructure.model.TransactionJpaModel;
import com.garyfrancodev.ExpenseManagerInfrastructure.model.TransferJpaModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface TransferJpaRepository extends JpaRepository<TransferJpaModel, UUID> {

    List<TransferJpaModel> findAllByUser_Id(UUID userId);
}
