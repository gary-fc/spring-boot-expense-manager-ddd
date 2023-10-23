package com.garyfrancodev.ExpenseManagerApi.controller;

import an.awesome.pipelinr.Pipeline;
import com.garyfrancodev.ExpenseManagerApplication.dtos.user.CreateUserDto;
import com.garyfrancodev.ExpenseManagerApplication.use_cases.user.CreateUserCommand;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Tag(name = "User Controller")
@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/user")
public class UserController {
    Logger logger = LoggerFactory.getLogger(UserController.class);
    @Autowired
    private Pipeline pipeline;

    @PostMapping()
    public String createUser(@RequestBody CreateUserDto createUserDto) {
        CreateUserCommand createUserCommand = new CreateUserCommand(createUserDto);
        pipeline.send(createUserCommand);
        logger.info("Oki");
        return "asd";
    }

    @GetMapping()
    public String getUsers() {
        return "asd";
    }
}
