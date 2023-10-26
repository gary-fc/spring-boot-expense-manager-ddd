package com.garyfrancodev.ExpenseManagerApplication.use_cases.user;

import an.awesome.pipelinr.Command;
import com.garyfrancodev.ExpenseManagerApplication.dtos.user.LoginDto;
import com.garyfrancodev.ExpenseManagerDomain.services.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class LoginUserHandler implements Command.Handler<LoginUserCommand, ResponseEntity<Map<String, String>>> {
    private final AuthService authService;

    public LoginUserHandler(AuthService authService) {
        this.authService = authService;
    }

    @Override
    public ResponseEntity<Map<String,String>> handle(LoginUserCommand loginUserCommand) {
        LoginDto loginDto = loginUserCommand.getLoginDto();
        return authService.login(loginDto.getEmail(), loginDto.getPassword());
    }
}
