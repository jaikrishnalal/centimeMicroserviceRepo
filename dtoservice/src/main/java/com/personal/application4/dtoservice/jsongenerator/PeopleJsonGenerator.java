package com.personal.application4.dtoservice.jsongenerator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.application4.dtoservice.annotation.LogMethodParam;
import com.personal.application4.dtoservice.dto.PeopleSubClassDTO;
import com.personal.application4.dtoservice.model.People;

@Service
public class PeopleJsonGenerator {
	
	@Autowired
	PeopleSubClassDTO peopleSubClassDto;
	
	 @LogMethodParam
	 public List<PeopleSubClassDTO> retrievePeopleData(List<People> peoplesData) {
	        Map<Integer,PeopleSubClassDTO> peopleMap = new HashMap<>();
	        
	        
	        for (People people: peoplesData) {
	        	PeopleSubClassDTO parent ;
	        	if (people.getParentId() < 1) {
	        		 parent = new PeopleSubClassDTO();
	        		 parent.setName(people.getName());
	 	            parent.setId(people.getId());
	 	            parent.setParentId(0);     
	 	           peopleMap.put(people.getId(), parent);
	        	} 
	        }
	        for (People people: peoplesData) {
	        	PeopleSubClassDTO peopleChild;
	        	PeopleSubClassDTO peopleParent;
				if (people.getParentId() > 0){
	        	
	        		peopleChild = new PeopleSubClassDTO();
	        		peopleParent = peopleMap.get(people.getParentId());
	        		peopleChild.setId(people.getId());
	        		peopleChild.setName(people.getName());
	        		peopleChild.setParentId(people.getParentId());
	        		peopleParent.addSubClass(peopleChild);
	        		peopleMap.put(people.getParentId(), peopleParent);
	        		peopleMap.put(people.getId(), peopleChild);
	        	}
	        	
	        }  	
	       
	        List<PeopleSubClassDTO> peoplesDTO = new ArrayList<PeopleSubClassDTO>(); 
	        for(PeopleSubClassDTO peopleDTO : peopleMap.values()){
	            if(peopleDTO.getParentId()== 0)
	            	peoplesDTO.add(peopleDTO);
	        }

	        return peoplesDTO;
			
	    }

	 

}
