package org.kt.temp.dao;

import java.util.List;

import org.kt.temp.pojo.User;

public interface UserDao {
	List<User> findAll();
}
