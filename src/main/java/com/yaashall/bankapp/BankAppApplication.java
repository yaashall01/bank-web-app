package com.yaashall.bankapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"com.yaashall.bankapp.controller", "com.yaashall.bankapp.service"})
@EntityScan("com.yaashall.bankapp.entity")
@EnableJpaRepositories("com.yaashall.bankapp.repository")
public class BankAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BankAppApplication.class, args);
	}

}
