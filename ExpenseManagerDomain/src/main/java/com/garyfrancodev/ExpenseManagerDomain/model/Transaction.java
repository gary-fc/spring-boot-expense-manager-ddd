package com.garyfrancodev.ExpenseManagerDomain.model;

import com.garyfrancodev.ExpenseManagerSharedKernel.core.AggregateRoot;
import lombok.Getter;

@Getter
public class Transaction extends AggregateRoot {
    private double count;
}
