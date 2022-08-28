package com.personal.application2.helloservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HelloserviceApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(HelloserviceApplication.class, args);
	}

}
