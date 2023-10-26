package com.garyfrancodev.ExpenseManagerApplication.dtos.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class LoginDto {
    public String email;
    public String password;
}
