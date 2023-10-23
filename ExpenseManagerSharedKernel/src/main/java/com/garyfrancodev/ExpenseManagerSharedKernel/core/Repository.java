package com.garyfrancodev.ExpenseManagerSharedKernel.core;

import java.util.concurrent.CompletableFuture;

public interface Repository<T extends AggregateRoot, TId> {
    CompletableFuture<T> findByIdAsync(TId id);

    CompletableFuture<Void> createAsync(T obj);
}
