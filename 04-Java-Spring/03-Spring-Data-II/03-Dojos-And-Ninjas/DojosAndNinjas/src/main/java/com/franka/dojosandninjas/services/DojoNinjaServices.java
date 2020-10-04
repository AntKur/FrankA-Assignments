package com.franka.dojosandninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.franka.dojosandninjas.models.Dojo;
import com.franka.dojosandninjas.models.Ninja;
import com.franka.dojosandninjas.repositories.DojoRepository;
import com.franka.dojosandninjas.repositories.NinjaRepository;

@Service
public class DojoNinjaServices {
	private final NinjaRepository nRep;
	private final DojoRepository dRep;
	
	public DojoNinjaServices(NinjaRepository nRep, DojoRepository dRep) {
		this.nRep = nRep;
		this.dRep = dRep;
	}
	
	public List<Dojo> getAllDojos(){
		return dRep.findAll();
	}
	
	public Dojo createDojo(Dojo dojo) {
		return dRep.save(dojo);
	}
	
	public Ninja createNinja(Ninja ninja) {
		return nRep.save(ninja);
	}
	
	public Dojo findDojo(Long id) {
		return dRep.findById(id).orElse(null);
	}
}
