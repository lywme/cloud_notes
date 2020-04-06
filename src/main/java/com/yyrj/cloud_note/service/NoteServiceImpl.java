package com.yyrj.cloud_note.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yyrj.cloud_note.dao.NoteDao;
import com.yyrj.cloud_note.entity.Note;
import com.yyrj.cloud_note.util.NoteResult;

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

}
