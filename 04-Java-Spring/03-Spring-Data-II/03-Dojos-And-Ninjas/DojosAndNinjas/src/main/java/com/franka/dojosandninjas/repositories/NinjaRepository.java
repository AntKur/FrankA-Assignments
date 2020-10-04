package com.franka.dojosandninjas.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.franka.dojosandninjas.models.Dojo;
import com.franka.dojosandninjas.models.Ninja;

@Repository
public interface NinjaRepository extends CrudRepository<Ninja, Long> {
	
	List<Ninja> findAll();
	@Query("SELECT u FROM Ninja u where u.dojo =?1")
	List<Ninja> findByDojo(Dojo dojo);
}
