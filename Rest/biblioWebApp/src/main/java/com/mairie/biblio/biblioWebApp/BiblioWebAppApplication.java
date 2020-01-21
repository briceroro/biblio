package com.mairie.biblio.biblioWebApp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;



@SpringBootApplication
@EnableFeignClients("com.mairie")
public class BiblioWebAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BiblioWebAppApplication.class, args);
	}

}
