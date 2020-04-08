package com.yyrj.cloud_note.service;

import java.util.List;

import com.yyrj.cloud_note.entity.Note;
import com.yyrj.cloud_note.util.NoteResult;

public interface NoteService {
	public NoteResult<List<Note>> loadBookNotes(String bookId);
	public NoteResult<Note> loadNote(String noteId);
	public NoteResult<Note> updateNote(Note note);
	public NoteResult<String> addNote(String title,String userId,String bookId);
}
