package com.garyfrancodev.ExpenseManagerInfrastructure.repositories.category;

import com.garyfrancodev.ExpenseManagerDomain.enums.CategoryType;
import com.garyfrancodev.ExpenseManagerInfrastructure.model.CategoryJpaModel;
import com.garyfrancodev.ExpenseManagerInfrastructure.model.UserJpaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface CategoryJpaRepository extends JpaRepository<CategoryJpaModel, UUID> {
    @Query("select t from CategoryJpaModel t where t.user = :user")
    List<CategoryJpaModel> getCategoryJpaModelsByUserId(@Param("user") UserJpaModel userJpaModel);
    @Query("select t from CategoryJpaModel t where t.user = :user and t.categoryName = :categoryName")
    CategoryJpaModel getCategoryJpaModelsByUserIdByCategoryType(@Param("user") UserJpaModel userJpaModel, @Param("categoryName")String nameDefault);
}
