package com.garyfrancodev.ExpenseManagerInfrastructure.repositories.user;

import com.garyfrancodev.ExpenseManagerInfrastructure.model.UserJpaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserCrudRepository extends JpaRepository<UserJpaModel, UUID> {
    Optional<UserJpaModel> findByEmail(String username);
}
