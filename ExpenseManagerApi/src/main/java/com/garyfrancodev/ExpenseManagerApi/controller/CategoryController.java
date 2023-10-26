package com.garyfrancodev.ExpenseManagerApi.controller;

import an.awesome.pipelinr.Pipeline;
import com.garyfrancodev.ExpenseManagerApplication.dtos.category.CreateCategoryDto;
import com.garyfrancodev.ExpenseManagerApplication.dtos.user.CreateUserDto;
import com.garyfrancodev.ExpenseManagerApplication.use_cases.category.CreateCategoryCommand;
import com.garyfrancodev.ExpenseManagerApplication.use_cases.user.CreateUserCommand;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Tag(name = "Category Controller")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/category")
public class CategoryController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private Pipeline pipeline;

    @PostMapping()
    public UUID createCategory(@RequestBody CreateCategoryDto createCategoryDto) {
        CreateCategoryCommand createCategoryCommand = new CreateCategoryCommand(createCategoryDto);
        return createCategoryCommand.execute(pipeline);
    }
}
