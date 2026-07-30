package com.example.recomendacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RecomendacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecomendacionApplication.class, args);
	}

}
