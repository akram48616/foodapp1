package com.food.dao;

import java.util.List;

import com.food.model.user;

public interface userdao {
	List<user> getAllUsers();
	user getUserId(int userid);
	boolean addUser(user u);
	void updateUser(user u);
	void deleteUser(int userid);

}
