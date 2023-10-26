package com.garyfrancodev.ExpenseManagerApi;

import com.garyfrancodev.ExpenseManagerDomain.repositories.AccountRepository;
import com.garyfrancodev.ExpenseManagerDomain.repositories.CategoryRepository;
import com.garyfrancodev.ExpenseManagerDomain.repositories.UserRepository;
import com.garyfrancodev.ExpenseManagerDomain.services.AuthService;
import com.garyfrancodev.ExpenseManagerInfrastructure.repositories.account.AccountJpaRepository;
import com.garyfrancodev.ExpenseManagerInfrastructure.repositories.category.CategoryJpaRepository;
import com.garyfrancodev.ExpenseManagerInfrastructure.repositories.user.UserJpaRepository;
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
        return new UserJpaRepository();
    }

    @Bean(name = "categoryRepository")
    public CategoryRepository categoryRepository() {
        return new CategoryJpaRepository();
    }

    @Bean(name = "accountRepository")
    public AccountRepository accountRepository() {
        return new AccountJpaRepository();
    }

    @Bean(name = "authService")
    public AuthService authService(){
        return new AuthServiceImpl();
    }
}
