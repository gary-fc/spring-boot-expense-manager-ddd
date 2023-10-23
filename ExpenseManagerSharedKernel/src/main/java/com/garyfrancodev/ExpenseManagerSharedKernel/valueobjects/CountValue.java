package com.garyfrancodev.ExpenseManagerSharedKernel.valueobjects;

import com.garyfrancodev.ExpenseManagerSharedKernel.core.BusinessRuleValidationException;
import com.garyfrancodev.ExpenseManagerSharedKernel.core.ValueObject;
import lombok.Getter;

@Getter
public class CountValue extends ValueObject {
    private final int value;

    public CountValue(int value) throws BusinessRuleValidationException {
        if (value < 0) {
            throw new BusinessRuleValidationException("Cantidad value cannot be negative");
        }

        this.value = value;
    }

    public static int implicitToInt(CountValue countValue) {
        return countValue.value;
    }

    public static CountValue implicitToCountValue(int value) throws BusinessRuleValidationException {
        return new CountValue(value);
    }
}
