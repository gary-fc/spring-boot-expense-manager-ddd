package com.garyfrancodev.ExpenseManagerSharedKernel.core;

import lombok.Getter;

import java.io.Serializable;

@Getter
public class BusinessRuleValidationException extends Exception implements Serializable {
    private final BusinessRule brokenRule;
    private final String details;

    public BusinessRuleValidationException(BusinessRule brokenRule) {
        super(brokenRule.getMessage());
        this.brokenRule = brokenRule;
        this.details = brokenRule.getMessage();
    }

    public BusinessRuleValidationException(String message) {
        super(message);
        this.brokenRule = null;
        this.details = message;
    }

    protected BusinessRuleValidationException(String message, Throwable cause) {
        super(message, cause);
        this.brokenRule = null;
        this.details = message;
    }

    @Override
    public String toString() {
        String name = (brokenRule == null) ? "BusinessRule" : brokenRule.getClass().getName();
        return name + ": " + details;
    }
}
