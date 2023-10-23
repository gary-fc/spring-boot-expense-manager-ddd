package com.garyfrancodev.ExpenseManagerApplication.use_cases.user;

import an.awesome.pipelinr.Command;
import com.garyfrancodev.ExpenseManagerApplication.dtos.user.CreateUserDto;
import com.garyfrancodev.ExpenseManagerDomain.enums.CategoryType;
import com.garyfrancodev.ExpenseManagerDomain.factories.user.CreateUser;
import com.garyfrancodev.ExpenseManagerDomain.factories.user.UserFactory;
import com.garyfrancodev.ExpenseManagerDomain.model.User;
import com.garyfrancodev.ExpenseManagerDomain.repositories.UserRepository;
import com.garyfrancodev.ExpenseManagerSharedKernel.core.BusinessRuleValidationException;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateUserHandler implements Command.Handler<CreateUserCommand, UUID> {
    private final UserFactory _userFactory;
    private final UserRepository _userRepository;

    public CreateUserHandler(UserRepository userRepository) {
        this._userRepository = userRepository;
        this._userFactory = new CreateUser();
    }

    @Override
    public UUID handle(CreateUserCommand createUserCommand) {
        CreateUserDto createUserDto = createUserCommand.createUserDto;
        User user = _userFactory.create(createUserDto.getFirstName(), createUserDto.getLastName(), createUserDto.getEmail(), createUserDto.getPassword());
        try {
            user.addCategory("Allowance", "", "gf-icon-salary", CategoryType.INCOME, user);
            user.addCategory("Salary", "", "gf-icon-salary", CategoryType.INCOME, user);
            user.addCategory("Bonus", "", "gf-icon-salary", CategoryType.INCOME, user);

            user.addCategory("Food", "", "gf-icon-salary", CategoryType.EXPENSE, user);
            user.addCategory("Social Life", "", "gf-icon-salary", CategoryType.EXPENSE, user);
            user.addCategory("Education", "", "gf-icon-salary", CategoryType.EXPENSE, user);

            _userRepository.create(user);
            return user.getId();
        } catch (BusinessRuleValidationException e) {
            throw new RuntimeException(e);
        }
    }
}
