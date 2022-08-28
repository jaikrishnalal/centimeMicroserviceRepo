package com.personal.application.swaggermicroservice;

import java.net.URI;
import java.net.URISyntaxException;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.personal.application.swaggermicroservice.exception.InvalidJsonException;
import com.personal.application.swaggermicroservice.model.User;

@RestController
@Validated
public class PrimaryService {
	
	private static Logger LOGGER = LoggerFactory.getLogger(PrimaryService.class);

	
	@Autowired
	private RestTemplate restTemplate;
	
	@GetMapping("/checkService")
	public ResponseEntity<String> isServiceUp(String service) {
		LOGGER.info("Check if service is up");

		return ResponseEntity.status(HttpStatus.OK).body("Up");
	}

	@PostMapping("/welcomeUser")
	public ResponseEntity<String> welcomeUser(@Valid @RequestBody User user) throws URISyntaxException {
		LOGGER.info("post welcome request");
		
		if (user.getFirstName().isBlank() || user.getSurName().isBlank()) {
			throw new InvalidJsonException("Invalid Json");
		}

		String welcomeMessage = "";
		ResponseEntity<String> userdata = null;
	
			  HttpHeaders headers=new HttpHeaders();
		        headers.set("Content-Type", "application/json");
	    
			HttpEntity<User> request = new HttpEntity<User>(user, headers);
				
		String userurl = "http://localhost:8083";
		URI userUri = new URI(userurl);
		
		LOGGER.info("fetch welcome string");
		welcomeMessage = restTemplate.getForObject("http://localhost:8082/initmsg", String.class);
		LOGGER.info("welcomeMessage= "+welcomeMessage);
		LOGGER.info("post user data: fname= "+user.getFirstName() + " surname=" +user.getSurName());
		userdata = restTemplate.postForEntity(userUri + "/fetchuser",request, String.class);
		LOGGER.info("userdata= "+userdata);

		return ResponseEntity
				.status(HttpStatus.OK)
				.body( welcomeMessage + " " + userdata.getBody()) ;
	}
}
