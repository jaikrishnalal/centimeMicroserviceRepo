package com.personal.application4.dtoservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.application4.dtoservice.model.People;

public interface PeopleRepository extends JpaRepository<People, Integer>{

}
