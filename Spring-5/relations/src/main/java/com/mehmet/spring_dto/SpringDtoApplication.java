package com.mehmet.spring_dto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.mehmet.configuration.GlobalProperties;

@SpringBootApplication(scanBasePackages = "com.mehmet")
@EnableJpaRepositories(basePackages = "com.mehmet.repository")
@EntityScan(basePackages = "com.mehmet.entities")
@PropertySource(value = "classpath:app.properties")
@EnableConfigurationProperties(value = GlobalProperties.class)

public class SpringDtoApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringDtoApplication.class, args);
	}
}

// public class SpringDtoApplication {

// public static void main(String[] args) {
// SpringApplication.run(SpringDtoApplication.class, args);
// }

// }
