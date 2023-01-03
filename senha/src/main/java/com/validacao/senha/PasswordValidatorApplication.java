package com.validacao.senha;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class PasswordValidatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(PasswordValidatorApplication.class, args);
	}

}
