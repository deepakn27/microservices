package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
public class SpringSecurityBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringSecurityBootApplication.class, args);
	}

}
