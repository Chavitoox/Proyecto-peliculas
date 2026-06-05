package com.example.pelicula;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class PeliculaApplication {

	public static void main(String[] args) {
		SpringApplication.run(PeliculaApplication.class, args);
	}

}
