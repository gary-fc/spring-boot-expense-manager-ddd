package com.garyfrancodev.ExpenseManagerApi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(
		basePackages = {
				"com.garyfrancodev.ExpenseManagerApi.controller",
				"com.garyfrancodev.ExpenseManagerApplication.use_cases",
				"com.garyfrancodev.ExpenseManagerApplication.config",
				"com.garyfrancodev.ExpenseManagerInfrastructure.model",
				"com.garyfrancodev.ExpenseManagerInfrastructure.repositories",
		}
)
@EntityScan("com.garyfrancodev.ExpenseManagerInfrastructure.model")
@EnableJpaRepositories(basePackages = {"com.garyfrancodev.ExpenseManagerInfrastructure.repositories"})
public class ExpenseManagerApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExpenseManagerApiApplication.class, args);
	}

}
