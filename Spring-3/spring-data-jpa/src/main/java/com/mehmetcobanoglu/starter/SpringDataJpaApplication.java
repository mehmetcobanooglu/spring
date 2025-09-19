package com.mehmetcobanoglu.starter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import jakarta.persistence.Entity;

@SpringBootApplication
@EntityScan(basePackages = { "com.mehmetcobanoglu" })
@ComponentScan(basePackages = { "com.mehmetcobanoglu" })
@EnableJpaRepositories(basePackages = { "com.mehmetcobanoglu" })
public class SpringDataJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDataJpaApplication.class, args);
	}

}
