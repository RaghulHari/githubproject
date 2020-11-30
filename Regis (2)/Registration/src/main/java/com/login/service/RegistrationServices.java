package com.login.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.login.model.Admin;
import com.login.model.User;
import com.login.repository.*;

@Service
public class RegistrationServices {
	@Autowired
	private CrudRepo repo;
	private CrudRepos repos;

	public User saveUser(User user) {
		return repo.save(user);
	}
	public User fetchUserByPhone(String phoneNo)
	{
		return repo.findByPhoneNo(phoneNo);
	}

	public User fetchUserByEmailid(String email) {
		return repo.findByEmailId(email);

	}
	
	public Admin fetchAdminByEmailIdAndPassword(String email, String password) {
		
		return repos.findByEmailIdAndPassword(email, password);
		
	}


	public User fetchUserByEmailIdAndPassword(String email, String password) {
		return repo.findByEmailIdAndPassword(email, password);

	}

	public User upUser(Integer id, String password) {

		
	 Optional<User> db= repo.findById(id); 
	 if(db.isPresent())
	 {
		 User uu = db.get();
		 uu.setPassword(password);
		 
	 }
	
	 User uu1 = db.get();
	 User uu2 = repo.save(uu1);
	 return uu2;
	 
		 
	}

	public void deleteUserById(Integer id) {

		repo.deleteById(id);
	}

	public List<User> getAllUsers() {
		return repo.findAll();
	}
	
	public User getUserById(String emailId) {
		return repo.findByEmailId(emailId);
	}
}
