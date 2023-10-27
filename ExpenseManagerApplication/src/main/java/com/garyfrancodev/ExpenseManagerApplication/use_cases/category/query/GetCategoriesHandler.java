package com.garyfrancodev.ExpenseManagerApplication.use_cases.category.query;

import an.awesome.pipelinr.Command;
import com.garyfrancodev.ExpenseManagerApplication.dtos.category.CategoryDto;
import com.garyfrancodev.ExpenseManagerDomain.model.Category;
import com.garyfrancodev.ExpenseManagerDomain.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetCategoriesHandler implements Command.Handler<GetCategoriesQuery, ResponseEntity<List<CategoryDto>>> {
    private final CategoryRepository _categoryRepository;

    @Autowired
    public GetCategoriesHandler(CategoryRepository categoryRepository) {
        this._categoryRepository = categoryRepository;
    }

    @Override
    public ResponseEntity<List<CategoryDto>> handle(GetCategoriesQuery getCategoriesQuery) {
        List<Category> categoryList = _categoryRepository.getCategoriesByUserId(getCategoriesQuery.getUserId());
        List<CategoryDto> categoryDtos = categoryList.stream().map(category -> new CategoryDto(category.getCategoryIcon(),category.getCategoryName().getName(), category.getCategoryDescription(), category.getCategoryType(), category.getUserId(), category.getId())).toList();

        return ResponseEntity.ok(categoryDtos);

    }
}
