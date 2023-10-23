package com.garyfrancodev.ExpenseManagerSharedKernel.valueobjects;

import com.garyfrancodev.ExpenseManagerSharedKernel.core.BusinessRuleValidationException;
import com.garyfrancodev.ExpenseManagerSharedKernel.core.ValueObject;
import com.garyfrancodev.ExpenseManagerSharedKernel.rules.StringNotNullOrEmptyRule;

public class CategoryNameValue extends ValueObject {
    private String name;

    public CategoryNameValue(String name) throws BusinessRuleValidationException {
        checkRule(new StringNotNullOrEmptyRule(name));
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
