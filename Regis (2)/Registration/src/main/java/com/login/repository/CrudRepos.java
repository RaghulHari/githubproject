package com.login.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.login.model.Admin;
import com.login.model.User;

public interface CrudRepos extends JpaRepository<Admin, Integer>{
	public Admin findByEmailIdAndPassword(String email, String password);
}
