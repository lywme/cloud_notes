package com.yyrj.cloud_note.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyrj.cloud_note.entity.Notebook;
import com.yyrj.cloud_note.service.BookService;
import com.yyrj.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/book")
public class LoadBooksController {
	@Resource
	private BookService service;
	
	@RequestMapping("/loadBooks.do")
	@ResponseBody
	public NoteResult<List<Notebook>> loadbooks(String userId)
	{
		NoteResult<List<Notebook>> result=service.loadUserBooks(userId);
		return result;
	}
}
