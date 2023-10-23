package com.garyfrancodev.ExpenseManagerSharedKernel.core;

import java.util.Objects;

public abstract class ValueObject {
    protected static void checkRule(BusinessRule rule) throws BusinessRuleValidationException {
        Objects.requireNonNull(rule, "Rule cannot be null");
        if (!rule.isValid()) {
            throw new BusinessRuleValidationException(rule);
        }
    }
}
