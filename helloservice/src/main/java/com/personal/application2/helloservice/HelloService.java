package com.personal.application2.helloservice;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloService {
	private static Logger LOGGER = LoggerFactory.getLogger(HelloService.class);

	
	@GetMapping("/initmsg")
	public ResponseEntity<String> getInitMsg() {
		
		LOGGER.info("fetch welcome message");
		return ResponseEntity.status(HttpStatus.OK).body("Hello");
	}


}
