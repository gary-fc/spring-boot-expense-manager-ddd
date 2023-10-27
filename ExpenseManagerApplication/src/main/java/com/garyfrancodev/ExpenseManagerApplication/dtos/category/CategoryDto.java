package com.garyfrancodev.ExpenseManagerApplication.dtos.category;

import com.garyfrancodev.ExpenseManagerDomain.enums.CategoryType;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.UUID;
@AllArgsConstructor
public class CategoryDto {
    public String categoryName;
    public String categoryIcon;
    public String categoryDescription;
    public CategoryType categoryType;
    public UUID userId;
    public UUID id;
}
