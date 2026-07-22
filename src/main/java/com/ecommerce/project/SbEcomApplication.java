package com.ecommerce.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@ComponentScan(basePackages = {"com.ecommerce", "com.ecommerce.Ecom_Exception","com.ecommerce.Ecom_Service"})
@EntityScan(basePackages = "com.ecommerce.Ecom_Model")
@EnableJpaRepositories(basePackages = "com.ecommerce.Ecom_Repository")
public class SbEcomApplication {

	public static void main(String[] args) {
		SpringApplication.run(SbEcomApplication.class, args);
	}

}
