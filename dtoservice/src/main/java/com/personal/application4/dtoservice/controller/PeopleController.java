package com.personal.application4.dtoservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.application4.dtoservice.dto.PeopleSubClassDTO;
import com.personal.application4.dtoservice.jsongenerator.PeopleJsonGenerator;
import com.personal.application4.dtoservice.model.People;
import com.personal.application4.dtoservice.service.PeopleService;

@RestController
@RequestMapping("/api")
public class PeopleController {
	
	
	@Autowired
	private PeopleService peopleService;
	
	@Autowired 
	private PeopleJsonGenerator peopleJsonGenerator;
	
	@PostMapping("/addPerson")
	public List<People> addPeople(@RequestBody List<People> peoples){
		return peopleService.addPerson(peoples);
		
	}
	
	@GetMapping("/getperson/{id}")
	public People getPersonById(@PathVariable int id){
		return peopleService.getPersonById( id);
		
	}
	
	@GetMapping("/fetchAll")
	public List<People> getAllPersons(){
		return peopleService.getAllPersons();
		
	}
	
	@GetMapping("/fetchAllFormatted")
	public List<PeopleSubClassDTO> getAllPersonsFormatted(){
		return peopleJsonGenerator.retrievePeopleData(peopleService.getAllPersons());
		
	}




}
