package com.personal.application3.userservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserserviceApplication {
	private static Logger log = LoggerFactory.getLogger(UserserviceApplication.class);


	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

}
