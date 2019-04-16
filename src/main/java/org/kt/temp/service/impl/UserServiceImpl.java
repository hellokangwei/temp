package org.kt.temp.service.impl;

import java.util.List;

import org.kt.temp.dao.UserDao;
import org.kt.temp.pojo.User;
import org.kt.temp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}
	
	

}
