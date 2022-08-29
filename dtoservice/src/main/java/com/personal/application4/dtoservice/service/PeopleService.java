package com.personal.application4.dtoservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.application4.dtoservice.model.People;
import com.personal.application4.dtoservice.repository.PeopleRepository;

@Service
public class PeopleService {
	
	@Autowired
	private PeopleRepository peopleRepository;

	public List<People> addPerson(List<People> peoples) {
		
		return peopleRepository.saveAll(peoples);
	}

	public People getPersonById(int personId) {
		
		return peopleRepository.findById(personId).orElse(null);
	}

	public List<People> getAllPersons() {
		
		return peopleRepository.findAll();
	}

}
