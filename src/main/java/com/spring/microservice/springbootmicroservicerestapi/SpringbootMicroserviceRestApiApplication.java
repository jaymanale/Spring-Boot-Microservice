package com.spring.microservice.springbootmicroservicerestapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Spring Boot Microservices",
				description = "Spring Boot application REST API - Microservices",
				version = "v1.0",
				contact = @Contact(
						name = "Jayram Manale",
						email = "jaymanale29@gmail.com",
						url = "https://www.jayrammanale.com/"

				),
				license = @License(
						name = "Apache 2.0",
						url = "https://www.jayrammanale.com/"
				)

		)
)
public class SpringbootMicroserviceRestApiApplication {

	@Bean
	public ModelMapper modelMapper(){
		return new ModelMapper();
	}
	public static void main(String[] args) {
		SpringApplication.run(SpringbootMicroserviceRestApiApplication.class, args);
	}

}
