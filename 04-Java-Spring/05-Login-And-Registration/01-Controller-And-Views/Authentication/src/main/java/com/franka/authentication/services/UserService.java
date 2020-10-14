package com.franka.authentication.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franka.authentication.models.User;
import com.franka.authentication.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	
	public User registerUser(User user) {
		String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hashed);
		return  uRepo.save(user);
	}
	
	public User getByEmail(String email) {
		return uRepo.findByEmail(email);
	}
	
	public User getById(Long id) {
		return uRepo.findById(id).orElse(null);
	}
	
	public boolean verifyUser(String email, String password) {
		User user = uRepo.findByEmail(email);
		
		if(user == null) {
			return false;
		} else {
			if(BCrypt.checkpw(password, user.getPassword()))
				return true;
			else
				return false;
		}
	}
}
