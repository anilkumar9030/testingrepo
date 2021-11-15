package com.onlineshopping.user.service;

import java.util.List;

import com.onlineshopping.user.entity.User;

public interface UserService {
	
	public List<User> getUsers();
	public void add(User users);
	public List<User> findByUserName(String username);
	public User getUserById(Long id);
	public void delete(long id);
	public void deleteByName(String username);

}
