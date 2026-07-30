package com.example.resenia;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class ReseniaApplication {

	public static void main(String[] args) {
		SpringApplication.run(ReseniaApplication.class, args);
	}

}
