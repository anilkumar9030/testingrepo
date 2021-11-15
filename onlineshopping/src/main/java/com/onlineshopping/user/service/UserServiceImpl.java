package com.onlineshopping.user.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.onlineshopping.user.dao.UserRepository;
import com.onlineshopping.user.entity.User;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> getUsers(){
		return (List<User> repository.findAll());
		
	}
	public void add(User users) {
		
	}
	public List<User> findByUserName(String username){
		
	}
	public User getUserById(Long id) {
		
	}
	public void delete(long id) {
		
	}
	public void deleteByName(String username) {
		
	}
	

}
