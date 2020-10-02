package com.franka.people.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.franka.people.models.License;
import com.franka.people.models.Person;
import com.franka.people.repositories.LicenseRepository;
import com.franka.people.repositories.PersonRepository;

@Service
public class PersonLicenseService {
	private final PersonRepository pRep;
	private final LicenseRepository lRep;
	
	public PersonLicenseService(PersonRepository p, LicenseRepository l) {
		this.pRep = p;
		this.lRep = l;
	}
	
	public List<Person> findAllPersons(){
		return pRep.findAll();
	}
	
	public Person createPerson(Person p) {
		return pRep.save(p);
	}
	public License createLicense(License l) {
		l.setNumber(createNumber());
		return lRep.save(l);
	}
	
	public List<Person> unlicensedPersons(){
		return pRep.findByLicenseIsNull();
	}
	
	public int createNumber() {
		
		List<License> lis = lRep.findAllOrderByNumberDesc();
		if(lis.size()==0) {
			return 1;
		} else {
			int largestNumber = lis.get(0).getNumber();
			return ++largestNumber;
		}
	}
	
	public Person findPerson(Long id) {
		return pRep.findById(id).orElse(null);
	}
}
