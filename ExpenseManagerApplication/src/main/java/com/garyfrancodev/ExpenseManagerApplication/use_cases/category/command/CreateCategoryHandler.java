package com.garyfrancodev.ExpenseManagerApplication.use_cases.category.command;

import an.awesome.pipelinr.Command;
import com.garyfrancodev.ExpenseManagerApplication.dtos.category.CreateCategoryDto;
import com.garyfrancodev.ExpenseManagerApplication.use_cases.category.command.CreateCategoryCommand;
import com.garyfrancodev.ExpenseManagerDomain.model.Category;
import com.garyfrancodev.ExpenseManagerDomain.repositories.CategoryRepository;
import com.garyfrancodev.ExpenseManagerSharedKernel.core.BusinessRuleValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateCategoryHandler implements Command.Handler<CreateCategoryCommand, UUID> {
    private final CategoryRepository _categoryRepository;

    @Autowired
    public CreateCategoryHandler(CategoryRepository categoryRepository) {
        this._categoryRepository = categoryRepository;
    }

    @Override
    public UUID handle(CreateCategoryCommand createCategoryCommand) {
        CreateCategoryDto createCategoryDto = createCategoryCommand.getCreateCategoryDto();
        try {
            Category category = new Category(createCategoryDto.getCategoryIcon(), createCategoryDto.getCategoryName(), createCategoryDto.getCategoryDescription(), createCategoryDto.getCategoryType(), createCategoryDto.getUserId());
            _categoryRepository.create(category);
        } catch (BusinessRuleValidationException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
