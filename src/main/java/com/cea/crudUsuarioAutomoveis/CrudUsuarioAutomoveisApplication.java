package com.cea.crudUsuarioAutomoveis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class CrudUsuarioAutomoveisApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrudUsuarioAutomoveisApplication.class, args);
	}

}
