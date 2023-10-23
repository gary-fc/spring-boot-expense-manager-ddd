package com.garyfrancodev.ExpenseManagerSharedKernel.core;


import java.util.concurrent.CompletableFuture;

public interface UnitOfWork {
    CompletableFuture<Void> commit();
}
