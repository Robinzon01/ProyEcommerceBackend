package com.robin.proyecommer.backend;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.robin.proyecommer.backend.config.FileStorageProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties({FileStorageProperties.class})
public class ProyectoEcommerBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProyectoEcommerBackendApplication.class, args);
	}

	@Bean
	public ObjectMapper getObjectMapper(){
		return new ObjectMapper();
	}

}
