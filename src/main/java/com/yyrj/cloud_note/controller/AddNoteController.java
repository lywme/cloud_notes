package com.yyrj.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyrj.cloud_note.service.BookService;
import com.yyrj.cloud_note.service.NoteService;
import com.yyrj.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class AddNoteController {
	@Resource
	private NoteService service;
	
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult<String> execute(String title,String userId,String bookId)
	{
		NoteResult<String> result=service.addNote(title, userId, bookId);
		return result;
	}
}
