package com.project.transactionalspringboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class TransactionalspringbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(TransactionalspringbootApplication.class, args);
	}

}
