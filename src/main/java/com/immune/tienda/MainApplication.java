package com.immune.tienda;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories
public class MainApplication {
	
	public static void main(String[] args) {
		//Lanza la aplicación al completo
		SpringApplication.run(MainApplication.class, args);	
	}
}
