package com.personal.application4.dtoservice.dto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@Component
public class PeopleSubClassDTO {
	
	private String name;
	
	@JsonIgnore
	private Integer parentId;
	@JsonIgnore
	private Integer id;

	@JsonInclude(value = Include.NON_EMPTY)
	private List<PeopleSubClassDTO> subClasses;
	

	public PeopleSubClassDTO() {
		super();
		this.name = "";
		this.parentId = 0;
		this.subClasses =  new ArrayList<PeopleSubClassDTO>();;
		
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public int getParentId() {
		return parentId;
	}

	public void setParentId(int parentId) {
		this.parentId = parentId;
	}

	public PeopleSubClassDTO(String name, List<PeopleSubClassDTO> subClasses) {
		super();
		this.name = name;
		this.subClasses =  new ArrayList<PeopleSubClassDTO>();;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<PeopleSubClassDTO> getSubClasses() {
		return subClasses;
	}
	public void setSubClasses(List<PeopleSubClassDTO> subClasses) {
		this.subClasses = subClasses;
	}
	
	 public void addSubClass(PeopleSubClassDTO subClass){
	        if(subClass != null && !this.subClasses.contains(subClass))
	            this.subClasses.add(subClass);
	    }

	@Override
	public String toString() {
		return "PeopleSubClassDTO [name=" + name + ", subClasses=" + subClasses + "]";
	}
	
	
	
	

}
