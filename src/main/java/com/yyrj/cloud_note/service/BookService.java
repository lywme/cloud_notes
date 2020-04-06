package com.yyrj.cloud_note.service;

import java.util.List;

import com.yyrj.cloud_note.entity.Notebook;
import com.yyrj.cloud_note.util.NoteResult;

public interface BookService {
	public NoteResult<List<Notebook>> loadUserBooks(String userId);
}
