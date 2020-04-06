package com.yyrj.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyrj.cloud_note.entity.User;
import com.yyrj.cloud_note.service.UserService;
import com.yyrj.cloud_note.service.UserServiceImpl;
import com.yyrj.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/user")
public class LoginController {
	@Resource
	private UserService service;
	
	@RequestMapping("/login.do")
	@ResponseBody
	public NoteResult<User> login(String name,String password)
	{
		NoteResult<User> result=service.checkLogin(name, password);
		return result;
	}
	

}
