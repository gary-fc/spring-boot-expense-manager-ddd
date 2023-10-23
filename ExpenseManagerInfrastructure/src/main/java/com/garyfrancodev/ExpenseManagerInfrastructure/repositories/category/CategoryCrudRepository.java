package com.garyfrancodev.ExpenseManagerInfrastructure.repositories.category;

import com.garyfrancodev.ExpenseManagerDomain.model.Category;
import com.garyfrancodev.ExpenseManagerInfrastructure.model.CategoryJpaModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CategoryCrudRepository extends CrudRepository<CategoryJpaModel, UUID> {
}
