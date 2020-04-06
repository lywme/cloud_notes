package com.yyrj.cloud_note.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyrj.cloud_note.entity.Note;
import com.yyrj.cloud_note.service.NoteService;
import com.yyrj.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class LoadNoteController {
	@Resource
	private NoteService service;
	
	@ResponseBody
	@RequestMapping("/loadnotes.do")
	public NoteResult<List<Note>> execute(String bookId)
	{
		NoteResult<List<Note>> result=service.loadBookNotes(bookId);
		return result;
	}
}
