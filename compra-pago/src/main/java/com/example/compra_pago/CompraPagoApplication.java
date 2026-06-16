package com.example.compra_pago;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CompraPagoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CompraPagoApplication.class, args);
	}

}
