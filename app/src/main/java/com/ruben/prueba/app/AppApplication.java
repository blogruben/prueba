package com.ruben.prueba.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.ruben.prueba.client.service.ApiService;

@SpringBootApplication
//@Import(ApiService.class)
@ComponentScan(basePackages = {"com.ruben.prueba"})
public class AppApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppApplication.class, args);
	}

}
