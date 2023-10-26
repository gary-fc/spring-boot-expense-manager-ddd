package com.garyfrancodev.ExpenseManagerApplication.event_handlers;

import an.awesome.pipelinr.Notification;
import an.awesome.pipelinr.Pipeline;
import com.garyfrancodev.ExpenseManagerApplication.dtos.category.CreateCategoryDto;
import com.garyfrancodev.ExpenseManagerApplication.use_cases.category.CreateCategoryCommand;
import com.garyfrancodev.ExpenseManagerDomain.enums.CategoryType;
import com.garyfrancodev.ExpenseManagerDomain.events.CreatedUserEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateCategoryWhenCreatedUser implements Notification.Handler<CreatedUserEvent> {
    @Autowired
    private Pipeline pipeline;

    @Override
    public void handle(CreatedUserEvent createdUserEvent) {
        CreateCategoryDto createCategoryDto = new CreateCategoryDto("Allowance", "gf-icon-allowance", "", CategoryType.INCOME, createdUserEvent.getUserId());
        CreateCategoryCommand createCategoryCommand = new CreateCategoryCommand(createCategoryDto);
        createCategoryCommand.execute(pipeline);

        createCategoryDto = new CreateCategoryDto("Salary", "gf-icon-salary", "", CategoryType.INCOME, createdUserEvent.getUserId());
        createCategoryCommand = new CreateCategoryCommand(createCategoryDto);
        createCategoryCommand.execute(pipeline);

        createCategoryDto = new CreateCategoryDto("Bonus", "gf-icon-bonus", "", CategoryType.INCOME, createdUserEvent.getUserId());
        createCategoryCommand = new CreateCategoryCommand(createCategoryDto);
        createCategoryCommand.execute(pipeline);

        createCategoryDto = new CreateCategoryDto("Food", "gf-icon-food", "", CategoryType.EXPENSE, createdUserEvent.getUserId());
        createCategoryCommand = new CreateCategoryCommand(createCategoryDto);
        createCategoryCommand.execute(pipeline);

        createCategoryDto = new CreateCategoryDto("Education", "gf-icon-education", "", CategoryType.EXPENSE, createdUserEvent.getUserId());
        createCategoryCommand = new CreateCategoryCommand(createCategoryDto);
        createCategoryCommand.execute(pipeline);

        createCategoryDto = new CreateCategoryDto("Gym", "gf-icon-gym", "", CategoryType.EXPENSE, createdUserEvent.getUserId());
        createCategoryCommand = new CreateCategoryCommand(createCategoryDto);
        createCategoryCommand.execute(pipeline);
    }
}
