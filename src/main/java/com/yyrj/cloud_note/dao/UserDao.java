package com.yyrj.cloud_note.dao;

import org.springframework.stereotype.Repository;

import com.yyrj.cloud_note.entity.User;

public interface UserDao {
	public User findByName(String name);
	public void save(User newuser);
}
