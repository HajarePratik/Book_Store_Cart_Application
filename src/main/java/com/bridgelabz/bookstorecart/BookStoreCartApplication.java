package com.bridgelabz.bookstorecart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan("com.bridgelabz.bookstorecart")
@EnableJpaRepositories("com.bridgelabz.bookstorecart.repository")
@EnableEurekaClient
public class BookStoreCartApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreCartApplication.class, args);
	}

}
