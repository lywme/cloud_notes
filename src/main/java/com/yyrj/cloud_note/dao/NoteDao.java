package com.yyrj.cloud_note.dao;

import java.util.List;

import com.yyrj.cloud_note.entity.Note;

public interface NoteDao {
	public List<Note> findByBookId(String bookId);
	public Note findByNoteId(String noteId);
	public int updateNote(Note note);
	public void save(Note note);
}
