package com.carSelling.CarSelling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("com.carSelling.CarSelling.entity") 
@EnableJpaRepositories("com.carSelling.CarSelling.repository")
public class CarSellingApplication {

	public static void main(String[] args) {
		SpringApplication.run(CarSellingApplication.class, args);
	}

}
