package com.example.authservice;

import org.springframework.boot.SpringApplication;

public class TestAuthServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.from(AuthServiceApiApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}
