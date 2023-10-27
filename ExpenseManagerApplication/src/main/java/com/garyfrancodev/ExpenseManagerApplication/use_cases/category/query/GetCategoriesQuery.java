package com.garyfrancodev.ExpenseManagerApplication.use_cases.category.query;

import an.awesome.pipelinr.Command;
import com.garyfrancodev.ExpenseManagerApplication.dtos.category.CategoryDto;
import com.garyfrancodev.ExpenseManagerDomain.model.Category;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public class GetCategoriesQuery implements Command<ResponseEntity<List<CategoryDto>>> {
    private final UUID userId;

    public GetCategoriesQuery(UUID userId) {
        this.userId = userId;
    }

    public UUID getUserId() {
        return userId;
    }
}
