package com.yyrj.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyrj.cloud_note.entity.User;
import com.yyrj.cloud_note.service.UserService;
import com.yyrj.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/user")
public class UserRegistController {
	@Resource
	private UserService service;
	
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult<User> add(String name,String password,String nickname)
	{
		NoteResult result=service.addUser(name,password,nickname);
		return result;
	}
}
