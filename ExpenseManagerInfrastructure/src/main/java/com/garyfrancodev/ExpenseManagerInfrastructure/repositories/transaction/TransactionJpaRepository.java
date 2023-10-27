package com.garyfrancodev.ExpenseManagerInfrastructure.repositories.transaction;

import com.garyfrancodev.ExpenseManagerInfrastructure.model.TransactionJpaModel;
import com.garyfrancodev.ExpenseManagerInfrastructure.model.UserJpaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface TransactionJpaRepository extends JpaRepository<TransactionJpaModel, UUID> {
    List<TransactionJpaModel> findAllByAccountId(UUID id);

    List<TransactionJpaModel> findAllByUser_Id(UUID userId);

    @Query("select t from TransactionJpaModel t where t.user = :user and t.date between :startDate and :endDate")
    List<TransactionJpaModel> findAllByUser_IdByDateBetween(@Param("user") UserJpaModel user, @Param("startDate") Date startDate, @Param("endDate") Date endDate);

//    List<TransactionJpaModel> findAllByUser_IdByDateBetween(UUID userId, Date startDate, Date endDate);


}
