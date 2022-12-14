package com.svetlin.store.microservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MicroservicesApplication {

	public static void main(String[] args) {

		SpringApplication.run(MicroservicesApplication.class, args);
		System.out.println("Hello");
	}

}
