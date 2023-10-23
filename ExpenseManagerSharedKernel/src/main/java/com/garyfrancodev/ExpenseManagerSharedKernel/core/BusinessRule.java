package com.garyfrancodev.ExpenseManagerSharedKernel.core;

public interface BusinessRule {
    boolean isValid();
    String getMessage();
}
