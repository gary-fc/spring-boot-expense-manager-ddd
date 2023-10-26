package com.garyfrancodev.ExpenseManagerInfrastructure.repositories.category;

import com.garyfrancodev.ExpenseManagerDomain.model.Category;
import com.garyfrancodev.ExpenseManagerDomain.repositories.CategoryRepository;
import com.garyfrancodev.ExpenseManagerInfrastructure.model.CategoryJpaModel;
import com.garyfrancodev.ExpenseManagerInfrastructure.repositories.user.UserCrudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public class CategoryJpaRepository implements CategoryRepository {

    @Autowired
    private CategoryCrudRepository _categoryCrudRepository;
    @Autowired
    private UserCrudRepository _userCrudRepository;

    @Override
    public UUID create(Category category) {
        CategoryJpaModel categoryJpaModel = new CategoryJpaModel();
        categoryJpaModel.setCategoryIcon(category.getCategoryIcon());
        categoryJpaModel.setCategoryName(category.getCategoryName().getName());
        categoryJpaModel.setCategoryDescription(category.getCategoryDescription());
        categoryJpaModel.setCategoryType(category.getCategoryType());
        categoryJpaModel.setId(category.getId());
        categoryJpaModel.setUser(_userCrudRepository.findById(category.getUserId()).orElseThrow());
        return _categoryCrudRepository.save(categoryJpaModel).getId();
    }
}
