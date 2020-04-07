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
			result.setMsg("û�ж�Ӧ���ռǱ�");
		}
		else
		{
			result.setStatus(0);
			result.setMsg("��ѯ�ɹ�");
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
			result.setMsg("��ѯ�ɹ�");
			result.setData(note);
		}
		else
		{
			result.setStatus(1);
			result.setMsg("û��ѯ����Ӧ�ıʼ�");
		}
		return result;
	}

	public NoteResult<Note> updateNote(Note note) {
		NoteResult<Note> result=new NoteResult();

		int num=dao.updateNote(note);
		if(num==1)
		{
			result.setStatus(0);
			result.setMsg("�޸ıʼǳɹ�");
		}
		else
		{
			result.setStatus(1);
			result.setMsg("�޸ıʼ�ʧ��");
		}
		
		return result;
	}

}
