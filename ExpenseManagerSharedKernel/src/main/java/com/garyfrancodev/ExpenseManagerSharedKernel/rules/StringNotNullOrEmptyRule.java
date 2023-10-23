package com.garyfrancodev.ExpenseManagerSharedKernel.rules;

import com.garyfrancodev.ExpenseManagerSharedKernel.core.BusinessRule;

public class StringNotNullOrEmptyRule implements BusinessRule {
    private final String value;

    public StringNotNullOrEmptyRule(String value) {
        this.value = value;
    }

    @Override
    public String getMessage() {
        return "String cannot be null or empty";
    }

    @Override
    public boolean isValid() {
        return value != null && !value.isEmpty();
    }
}
