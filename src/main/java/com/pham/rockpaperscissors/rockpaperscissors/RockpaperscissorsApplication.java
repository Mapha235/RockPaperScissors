package com.pham.rockpaperscissors.rockpaperscissors;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.pham"})
public class RockpaperscissorsApplication {

	public static void main(String[] args) {
		SpringApplication.run(RockpaperscissorsApplication.class, args);
	}

}
