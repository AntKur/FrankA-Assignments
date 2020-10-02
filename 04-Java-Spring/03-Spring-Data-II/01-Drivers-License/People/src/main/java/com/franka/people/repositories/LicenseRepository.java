package com.franka.people.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.franka.people.models.License;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {
	List<License> findAll();
	@Query("FROM License ORDER BY number DESC")
	List<License> findAllOrderByNumberDesc();
}
