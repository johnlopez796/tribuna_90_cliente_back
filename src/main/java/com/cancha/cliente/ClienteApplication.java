package com.cancha.cliente;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
@SpringBootApplication
public class ClienteApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClienteApplication.class, args);
	}

}
