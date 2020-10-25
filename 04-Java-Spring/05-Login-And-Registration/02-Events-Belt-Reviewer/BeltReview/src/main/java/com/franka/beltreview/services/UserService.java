package com.franka.beltreview.services;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.franka.beltreview.models.User;
import com.franka.beltreview.repositories.UserRepository;

@Service
public class UserService {
	@Autowired
	private UserRepository uRepo;
	
	public User findUserById(Long id) {
		return uRepo.findById(id).orElse(null);
	}
	
	public User findUserByEmail(String email) {
		return uRepo.findByEmail(email);
	}
	
	public User registerUser(User user) {
		String hash = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
		user.setPassword(hash);
		return this.uRepo.save(user);
	}
	
	public boolean validateUser(String email, String password) {
		User user = this.uRepo.findByEmail(email);
		if(user == null)
			return false;
		return BCrypt.checkpw(password, user.getPassword());
	}
}
