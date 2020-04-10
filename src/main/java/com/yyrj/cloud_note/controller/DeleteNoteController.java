package com.yyrj.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyrj.cloud_note.entity.Note;
import com.yyrj.cloud_note.service.NoteService;
import com.yyrj.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/note")
public class DeleteNoteController {
	@Resource
	private NoteService service;
	
	@RequestMapping("del.do")
	@ResponseBody
	public NoteResult<Note> delNote(String noteId)
	{
		NoteResult<Note> result=service.delNote(noteId);
		return result;
	}
}
