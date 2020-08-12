package com.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableLoadTimeWeaving;

@SpringBootApplication
@EnableLoadTimeWeaving
public class AoptestApplication {

	public static void main(String[] args) {
		SpringApplication.run(AoptestApplication.class, args);
	}

}
