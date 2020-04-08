package com.yyrj.cloud_note.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yyrj.cloud_note.dao.NoteDao;
import com.yyrj.cloud_note.entity.Note;
import com.yyrj.cloud_note.util.NoteResult;
import com.yyrj.cloud_note.util.NoteUtil;

@Service("noteService")
public class NoteServiceImpl implements NoteService {
	@Resource
	private NoteDao dao;
	
	public NoteResult<List<Note>> loadBookNotes(String bookId) {
		NoteResult result=new NoteResult();
		List<Note> list=dao.findByBookId(bookId);
		if(list.size()==0)
		{
			result.setStatus(1);
			result.setMsg("没有对应的日记本");
		}
		else
		{
			result.setStatus(0);
			result.setMsg("查询成功");
			result.setData(list);
		}
		return result;
	}

	public NoteResult<Note> loadNote(String noteId) {
		NoteResult result=new NoteResult();
		Note note=dao.findByNoteId(noteId);
		
		if(note!=null)
		{
			result.setStatus(0);
			result.setMsg("查询成功");
			result.setData(note);
		}
		else
		{
			result.setStatus(1);
			result.setMsg("没查询到对应的笔记");
		}
		return result;
	}

	public NoteResult<Note> updateNote(Note note) {
		NoteResult<Note> result=new NoteResult();

		int num=dao.updateNote(note);
		if(num==1)
		{
			result.setStatus(0);
			result.setMsg("修改笔记成功");
		}
		else
		{
			result.setStatus(1);
			result.setMsg("修改笔记失败");
		}
		
		return result;
	}

	public NoteResult<String> addNote(String title, String userId, String bookId) {
		NoteResult<String> result=new NoteResult<String>();
		if(title!=null && userId!=null && bookId!=null)
		{
			Note note=new Note();
			note.setCn_note_id(NoteUtil.createId());
			note.setCn_notebook_id(bookId);
			note.setCn_user_id(userId);
			note.setCn_note_title(title);
			note.setCn_note_create_time(System.currentTimeMillis());
			note.setCn_note_last_modify_time(System.currentTimeMillis());
			dao.save(note);
			result.setStatus(0);
			result.setMsg("插入笔记成功");
			result.setMsg(note.getCn_note_id());
		}
		else
		{
			result.setStatus(1);
			result.setMsg("传入数据不完整");
		}

		return result;
	}

}
