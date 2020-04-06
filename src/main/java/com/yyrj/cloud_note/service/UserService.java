package com.yyrj.cloud_note.service;

import org.springframework.stereotype.Service;

import com.yyrj.cloud_note.dao.UserDao;
import com.yyrj.cloud_note.entity.User;
import com.yyrj.cloud_note.util.NoteResult;


public interface UserService {
	public NoteResult<User> checkLogin(String name,String password);
	public NoteResult<Object> addUser(String name,String password,String nickname);
}
