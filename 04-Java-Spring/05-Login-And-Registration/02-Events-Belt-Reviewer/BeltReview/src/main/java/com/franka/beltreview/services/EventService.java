package com.franka.beltreview.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franka.beltreview.models.Event;
import com.franka.beltreview.repositories.EventRepository;

@Service
public class EventService {
	@Autowired
	private EventRepository eRepo;
	
	public Event createEvent(Event event) {
		return this.eRepo.save(event);
	}
	
	public Event editEvent(Event event) {
		return this.eRepo.save(event);
	}
	
	public List<Event> getAllEvents(){
		return this.eRepo.findAll();
	}
	
	public List<Event> eventsInState(String state){
		return this.eRepo.findByState(state);
	}
	
	public List<Event> eventsOutsideOfState(String state){
		return this.eRepo.findByStateNot(state);
	}
}
