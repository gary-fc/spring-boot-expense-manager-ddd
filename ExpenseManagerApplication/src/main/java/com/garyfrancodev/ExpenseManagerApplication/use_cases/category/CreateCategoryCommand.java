package com.garyfrancodev.ExpenseManagerApplication.use_cases.category;

import an.awesome.pipelinr.Command;
import com.garyfrancodev.ExpenseManagerApplication.dtos.category.CreateCategoryDto;

import java.util.UUID;

public class CreateCategoryCommand implements Command<UUID> {
    private final CreateCategoryDto createCategoryDto;

    public CreateCategoryCommand(CreateCategoryDto createCategoryDto) {
        this.createCategoryDto = createCategoryDto;
    }

    public CreateCategoryDto getCreateCategoryDto() {
        return createCategoryDto;
    }
}
