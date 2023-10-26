package com.garyfrancodev.ExpenseManagerDomain.services;

import com.garyfrancodev.ExpenseManagerDomain.model.User;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface AuthService {
    ResponseEntity<Map<String, String>> login(String email, String password);
    ResponseEntity<String> register(User user);
}
