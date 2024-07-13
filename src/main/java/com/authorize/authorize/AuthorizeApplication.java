package com.authorize.authorize;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class AuthorizeApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthorizeApplication.class, args);
	}

}
