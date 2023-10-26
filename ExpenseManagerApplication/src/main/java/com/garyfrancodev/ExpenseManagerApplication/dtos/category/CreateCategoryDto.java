package com.garyfrancodev.ExpenseManagerApplication.dtos.category;

import com.garyfrancodev.ExpenseManagerDomain.enums.CategoryType;
import com.garyfrancodev.ExpenseManagerDomain.model.User;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class CreateCategoryDto {
    public String categoryName;
    public String categoryIcon;
    public String categoryDescription;
    public CategoryType categoryType;
    public UUID userId;
}
