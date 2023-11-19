package com.yaashall.bankapp;

import com.yaashall.bankapp.entity.Account;
import com.yaashall.bankapp.utils.AccountUtils.AccountStatus;
import com.yaashall.bankapp.utils.AccountUtils.AccountType;
import com.yaashall.bankapp.entity.User;
import com.yaashall.bankapp.repository.AccountRepository;
import com.yaashall.bankapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;

@SpringBootApplication
@ComponentScan({"com.yaashall.bankapp.controller", "com.yaashall.bankapp.service"})
@EntityScan("com.yaashall.bankapp.entity")
@EnableJpaRepositories("com.yaashall.bankapp.repository")
public class BankAppApplication {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private AccountRepository accountRepository;

	public static void main(String[] args) {
		SpringApplication.run(BankAppApplication.class, args);

	}

	@Bean
	public CommandLineRunner loadData() {

		CommandLineRunner commandLineRunner = args -> {
			// Create and save users
			User user1 = User.builder()
					.firstName("John")
					.lastName("Doe")
					.gender("Male")
					.address("123 Main St")
					.birthPlace("Springfield")
					.birthDate(LocalDate.of(1990, 1, 1))
					.phoneNumber("+1234567890")
					.email("john.doe@example.com")
					.password("password1")
					.build();

			User user2 = User.builder()
					.firstName("Jane")
					.lastName("Smith")
					.gender("Female")
					.address("456 Second St")
					.birthPlace("Springville")
					.birthDate(LocalDate.of(1985, 5, 20))
					.phoneNumber("+1234567891")
					.email("jane.smith@example.com")
					.password("password2")
					.build();

			userRepository.save(user1);
			userRepository.save(user2);

			// Create and save accounts associated with users
			Account account1 = Account.builder()
					.accountNumber("ACC123456")
					.balance(new BigDecimal("1000.00"))
					.accountStatus(AccountStatus.ACTIVE)
					.accountType(AccountType.SAVINGS)
					.createdOn(LocalDateTime.now())
					.updatedOn(LocalDateTime.now())
					.user(user1)
					.build();

			Account account2 = Account.builder()
					.accountNumber("ACC654321")
					.balance(new BigDecimal("5000.00"))
					.accountStatus(AccountStatus.ACTIVE)
					.accountType(AccountType.CHECKING)
					.createdOn(LocalDateTime.now())
					.updatedOn(LocalDateTime.now())
					.user(user2)
					.build();

			accountRepository.save(account1);
			accountRepository.save(account2);

		};

		return commandLineRunner;

	}


}
