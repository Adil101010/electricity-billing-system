package com.adil.electricitybilling;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.adil.electricitybilling")
public class ElectricityBillingApplication {

	public static void main(String[] args) {
		SpringApplication.run(ElectricityBillingApplication.class, args);
	}

}
