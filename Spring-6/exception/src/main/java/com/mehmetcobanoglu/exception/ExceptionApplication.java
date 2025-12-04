package com.mehmetcobanoglu.exception;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EntityScan(basePackages = { "com.mehmetcobanoglu" })
@EnableJpaRepositories(basePackages = { "com.mehmetcobanoglu" })
@ComponentScan(basePackages = { "com.mehmetcobanoglu" })
@EnableScheduling
public class ExceptionApplication {

	public static void main(String[] args) {
		SpringApplication.run(ExceptionApplication.class, args);
	}

}
