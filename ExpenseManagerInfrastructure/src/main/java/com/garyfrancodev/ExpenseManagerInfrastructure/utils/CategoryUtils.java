package com.garyfrancodev.ExpenseManagerInfrastructure.utils;

import com.garyfrancodev.ExpenseManagerDomain.model.Category;
import com.garyfrancodev.ExpenseManagerInfrastructure.model.CategoryJpaModel;

import java.util.List;
import java.util.stream.Collectors;

public class CategoryUtils {

    public static CategoryJpaModel mapToJpaEntity(Category category) {
        CategoryJpaModel categoryJpaModel = new CategoryJpaModel();
        categoryJpaModel.setId(category.getId());
        categoryJpaModel.setCategoryName(category.getCategoryName().getName());
        categoryJpaModel.setCategoryDescription(category.getCategoryDescription());
        categoryJpaModel.setCategoryIcon(category.getCategoryIcon());
        categoryJpaModel.setCategoryType(category.getCategoryType());
        return categoryJpaModel;
    }


    public static List<CategoryJpaModel> mapToJpaEntityList(List<Category> categories) {
        return categories.stream().map(CategoryUtils::mapToJpaEntity).collect(Collectors.toList());
    }
}
