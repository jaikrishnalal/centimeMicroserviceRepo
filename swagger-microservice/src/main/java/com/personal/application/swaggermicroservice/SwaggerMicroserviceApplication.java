package com.personal.application.swaggermicroservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

import com.personal.application.swaggermicroservice.exception.ServiceExceptionHandler;

@SpringBootApplication
@Import(ServiceExceptionHandler.class)
public class SwaggerMicroserviceApplication {
	private static Logger log = LoggerFactory.getLogger(SwaggerMicroserviceApplication.class);

	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	

	public static void main(String[] args) {
		SpringApplication.run(SwaggerMicroserviceApplication.class, args);
	}

}
 