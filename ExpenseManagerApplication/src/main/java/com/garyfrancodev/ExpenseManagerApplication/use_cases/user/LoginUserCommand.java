package com.garyfrancodev.ExpenseManagerApplication.use_cases.user;

import an.awesome.pipelinr.Command;
import com.garyfrancodev.ExpenseManagerApplication.dtos.user.LoginDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public class LoginUserCommand implements Command<ResponseEntity<Map<String, String>>> {
    private final LoginDto loginDto;

    public LoginUserCommand(LoginDto loginDto) {
        this.loginDto = loginDto;
    }

    public LoginDto getLoginDto() {
        return loginDto;
    }
}
