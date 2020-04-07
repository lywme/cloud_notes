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
public class UpdateNoteController {
	@Resource
	private NoteService service;
	
	@RequestMapping("/update.do")
	@ResponseBody
	public NoteResult updatenote(String noteId,String title,String body)
	{
		NoteResult<Note> result=null;
		if(noteId!="")
		{
			Note note=new Note();
			note.setCn_note_id(noteId);
			note.setCn_note_title(title);
			note.setCn_note_body(body);
			note.setCn_note_last_modify_time(System.currentTimeMillis());
			result=service.updateNote(note);
		}
		else
		{
			result.setStatus(2);
			result.setMsg("没有传入参数");
		}
		return result;
	}
}
