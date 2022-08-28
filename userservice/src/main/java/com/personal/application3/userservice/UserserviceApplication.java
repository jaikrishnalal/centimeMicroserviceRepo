package com.personal.application3.userservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class UserserviceApplication {
	private static Logger log = LoggerFactory.getLogger(UserserviceApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

}
