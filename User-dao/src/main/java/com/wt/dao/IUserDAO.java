package com.wt.dao;

import java.util.List;

import com.wt.po.User;

public interface IUserDAO {
	
	void save(User u);
	void delete(Integer uid);
	void update(User u);
	User findOne(Integer uid);
	List<User> findAll();
	
}
