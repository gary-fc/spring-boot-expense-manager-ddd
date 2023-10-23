package com.garyfrancodev.ExpenseManagerSharedKernel.valueobjects;

import com.garyfrancodev.ExpenseManagerSharedKernel.core.BusinessRuleValidationException;
import com.garyfrancodev.ExpenseManagerSharedKernel.core.ValueObject;
import com.garyfrancodev.ExpenseManagerSharedKernel.rules.EmailFormatRule;

public class UserEmailValue extends ValueObject {
    private String value;

    public UserEmailValue(String value) throws BusinessRuleValidationException {
        checkRule(new EmailFormatRule(value));
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
