package com.jpa.jpa_performans;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.jpa.jpa_performans.service.MusteriService;

import jakarta.persistence.EntityManagerFactory;

@SpringBootApplication
public class JpaPerformansApplication {

	public static void main(String[] args) {
		SpringApplication.run(JpaPerformansApplication.class, args);
	}

	@Bean
	CommandLineRunner test(MusteriService musteriService, EntityManagerFactory entityManagerFactory) {
		return args -> {
			var sessionFactory = entityManagerFactory.unwrap(org.hibernate.SessionFactory.class);
			var statistics = sessionFactory.getStatistics();

			statistics.clear();

			musteriService.cacheTest();
			musteriService.cacheTest();

			System.out.println("Cache Hit: " + statistics.getSecondLevelCacheHitCount());
			System.out.println("Cache Miss: " + statistics.getSecondLevelCacheMissCount());
			System.out.println("Cache Put: " + statistics.getSecondLevelCachePutCount());
		};
	}
}
