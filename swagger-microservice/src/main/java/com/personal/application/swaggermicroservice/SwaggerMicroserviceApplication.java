package com.personal.application.swaggermicroservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.web.client.RestTemplate;

import com.personal.application.swaggermicroservice.exception.ServiceExceptionHandler;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SwaggerMicroserviceApplication {
	private static Logger log = LoggerFactory.getLogger(SwaggerMicroserviceApplication.class);

	
	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();
	}
	
	@Bean
    public Docket productApi() {
	      return new Docket(DocumentationType.SWAGGER_2).select()
	         .apis(RequestHandlerSelectors.basePackage("com.personal.application.swaggermicroservice")).build();
	   }

	public static void main(String[] args) {
		SpringApplication.run(SwaggerMicroserviceApplication.class, args);
	}

}
 