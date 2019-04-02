package com.siddu.jpaexample.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.siddu.jpaexample")
@EntityScan("com.siddu.jpaexample")
@EnableJpaRepositories("com.siddu.jpaexample")
public class JPAExamples{
	public static void main(String[] args) {
		SpringApplication.run(JPAExamples.class, args);
	}

	
	
	
	
}
