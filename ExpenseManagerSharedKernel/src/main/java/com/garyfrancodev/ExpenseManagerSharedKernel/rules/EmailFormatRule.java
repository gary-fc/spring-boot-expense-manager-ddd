package com.garyfrancodev.ExpenseManagerSharedKernel.rules;

import com.garyfrancodev.ExpenseManagerSharedKernel.core.BusinessRule;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailFormatRule implements BusinessRule {
    private final String value;
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Z|a-z]{2,6}$");

    public EmailFormatRule(String value) {
        this.value = value;
    }

    @Override
    public String getMessage() {
        return "Email format invalid";
    }

    @Override
    public boolean isValid() {
        return value != null && !value.trim().isEmpty() && isValidEmail(value);
    }

    private boolean isValidEmail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
}
