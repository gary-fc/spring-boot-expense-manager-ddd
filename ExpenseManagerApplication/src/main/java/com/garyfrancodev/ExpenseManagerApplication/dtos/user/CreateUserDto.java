package com.garyfrancodev.ExpenseManagerApplication.dtos.user;

import lombok.Getter;

@Getter
public class CreateUserDto {
    public String firstName;
    public String lastName;
    public String email;
    public String password;

    public CreateUserDto() {
    }

    public CreateUserDto(String firstName, String lastName, String email, String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.email = email;
    }
}
