package com.garyfrancodev.ExpenseManagerInfrastructure.repositories.account;

import com.garyfrancodev.ExpenseManagerInfrastructure.model.AccountJpaModel;
import com.garyfrancodev.ExpenseManagerInfrastructure.model.UserJpaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface AccountJpaRepository extends JpaRepository<AccountJpaModel, UUID> {

    @Query("select SUM(t.amount) as sum from AccountJpaModel t where t.user = :user group by t.user")
    double total(@Param("user") UserJpaModel userJpaModel);

    @Query("select t from AccountJpaModel t where t.user = :user")
    List<AccountJpaModel> get(@Param("user") UserJpaModel userJpaModel);



}
