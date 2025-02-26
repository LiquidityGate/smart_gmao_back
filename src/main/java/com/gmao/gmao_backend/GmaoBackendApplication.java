package com.gmao.gmao_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.gmao.gmao_backend")
public class GmaoBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(GmaoBackendApplication.class, args);
	}

}
