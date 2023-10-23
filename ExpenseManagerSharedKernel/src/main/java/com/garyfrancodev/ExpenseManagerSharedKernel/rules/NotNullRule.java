package com.garyfrancodev.ExpenseManagerSharedKernel.rules;

import com.garyfrancodev.ExpenseManagerSharedKernel.core.BusinessRule;

public class NotNullRule implements BusinessRule {
    private final Object value;

    public NotNullRule(Object value) {
        this.value = value;
    }

    @Override
    public String getMessage() {
        return null;
    }

    @Override
    public boolean isValid() {
        return value != null;
    }
}
