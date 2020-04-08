package com.yyrj.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyrj.cloud_note.entity.Notebook;
import com.yyrj.cloud_note.service.BookService;
import com.yyrj.cloud_note.util.NoteResult;
import com.yyrj.cloud_note.util.NoteUtil;

@Controller
@RequestMapping("/book")
public class AddBookController {
	@Resource
	private BookService service;
	
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult execute(String userId,String title)
	{
		NoteResult result=null;
		if(userId!="" && title!="")
		{
			Notebook book=new Notebook();
			book.setCn_user_id(userId);
			book.setCn_notebook_name(title);
			book.setCn_notebook_id(NoteUtil.createId());
			result=service.addBook(book);
		}
		return result;
	}
}
