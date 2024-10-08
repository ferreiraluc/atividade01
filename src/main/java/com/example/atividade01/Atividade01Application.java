package com.example.atividade01;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
public class Atividade01Application {

	public static void main(String[] args) {
		SpringApplication.run(Atividade01Application.class, args);
	}

}
