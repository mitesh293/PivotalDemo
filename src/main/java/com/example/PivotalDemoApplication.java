package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.easynotes"})
@EnableJpaAuditing
public class PivotalDemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(PivotalDemoApplication.class, args);
	}
}
