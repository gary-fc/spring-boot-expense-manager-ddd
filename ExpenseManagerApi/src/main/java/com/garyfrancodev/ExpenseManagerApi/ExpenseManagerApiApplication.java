package com.garyfrancodev.ExpenseManagerApi;

import com.garyfrancodev.ExpenseManagerDomain.repositories.*;
import com.garyfrancodev.ExpenseManagerDomain.services.AuthService;
import com.garyfrancodev.ExpenseManagerInfrastructure.repositories.account.AccountRepositoryImpl;
import com.garyfrancodev.ExpenseManagerInfrastructure.repositories.category.CategoryRepositoryImpl;
import com.garyfrancodev.ExpenseManagerInfrastructure.repositories.transaction.TransactionRepositoryImpl;
import com.garyfrancodev.ExpenseManagerInfrastructure.repositories.transfer.TransferRepositoryImpl;
import com.garyfrancodev.ExpenseManagerInfrastructure.repositories.user.UserRepositoryImpl;
import com.garyfrancodev.ExpenseManagerInfrastructure.services.AuthServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(
        basePackages = {
                "com.garyfrancodev.ExpenseManagerApi.controller",
                "com.garyfrancodev.ExpenseManagerApplication.use_cases",
                "com.garyfrancodev.ExpenseManagerApplication.event_handlers",
                "com.garyfrancodev.ExpenseManagerApplication.config",
                "com.garyfrancodev.ExpenseManagerInfrastructure.model",
                "com.garyfrancodev.ExpenseManagerInfrastructure.config",
                "com.garyfrancodev.ExpenseManagerInfrastructure.repositories",
                "com.garyfrancodev.ExpenseManagerInfrastructure.jwt",
                "com.garyfrancodev.ExpenseManagerDomain.events",
        }
)
@EntityScan("com.garyfrancodev.ExpenseManagerInfrastructure.model")
@EnableJpaRepositories(basePackages = {"com.garyfrancodev.ExpenseManagerInfrastructure.repositories"})
public class ExpenseManagerApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(ExpenseManagerApiApplication.class, args);
    }

    @Bean(name = "userRepository")
    public UserRepository userRepository() {
        return new UserRepositoryImpl();
    }

    @Bean(name = "categoryRepository")
    public CategoryRepository categoryRepository() {
        return new CategoryRepositoryImpl();
    }

    @Bean(name = "accountRepository")
    public AccountRepository accountRepository() {
        return new AccountRepositoryImpl();
    }

    @Bean(name = "transactionRepository")
    public TransactionRepository transactionRepository() {
        return new TransactionRepositoryImpl();
    }

    @Bean(name = "transferRepository")
    public TransferRepository transferRepository() {
        return new TransferRepositoryImpl();
    }

    @Bean(name = "authService")
    public AuthService authService() {
        return new AuthServiceImpl();
    }
}
