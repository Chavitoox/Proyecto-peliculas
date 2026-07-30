package com.example.notificacion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class NotificacionApplication {

	public static void main(String[] args) {
		SpringApplication.run(NotificacionApplication.class, args);
	}

}
