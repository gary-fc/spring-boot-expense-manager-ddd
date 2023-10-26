package com.garyfrancodev.ExpenseManagerApplication.use_cases.user;

import an.awesome.pipelinr.Command;
import an.awesome.pipelinr.Pipeline;
import com.garyfrancodev.ExpenseManagerApplication.dtos.user.CreateUserDto;
import com.garyfrancodev.ExpenseManagerDomain.events.CreatedUserEvent;
import com.garyfrancodev.ExpenseManagerDomain.factories.user.CreateUser;
import com.garyfrancodev.ExpenseManagerDomain.factories.user.UserFactory;
import com.garyfrancodev.ExpenseManagerDomain.model.User;
import com.garyfrancodev.ExpenseManagerDomain.services.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class CreateUserHandler implements Command.Handler<CreateUserCommand, UUID> {
    private final UserFactory _userFactory;

    private final AuthService _authService;

    @Autowired
    private Pipeline pipeline;

    public CreateUserHandler(AuthService authService) {
        this._userFactory = new CreateUser();
        this._authService = authService;
    }

    @Override
    public UUID handle(CreateUserCommand createUserCommand) {
        CreateUserDto createUserDto = createUserCommand.getCreateUserDto();
        User user = _userFactory.create(createUserDto.getFirstName(), createUserDto.getLastName(), createUserDto.getEmail(), createUserDto.getPassword());
        _authService.register(user);
        new CreatedUserEvent(user.getId(), user.getDate()).send(pipeline);

        return user.getId();
    }
}
