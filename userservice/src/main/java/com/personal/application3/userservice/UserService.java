package com.personal.application3.userservice;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.application3.userservice.model.User;

@RestController
@RequestMapping("/")
@Validated
public class UserService {

	private static Logger LOGGER = LoggerFactory.getLogger(UserService.class);

	
	
	  @PostMapping("/fetchuser") 
	  public String getUserData(@Valid @RequestBody User user)	  {
	  
		  LOGGER.info("fetch user data");
	  
		  return user.getFirstName() + " " + user.getSurName(); 
	  }
	 
	 
	
		/*
		 * @PostMapping("/fetchuser") public ResponseEntity<String>
		 * getUserData(@RequestBody User user) { return
		 * ResponseEntity.status(HttpStatus.OK).body(user.getFirstName() + " " +
		 * user.getSurName()); }
		 */
	 

}
