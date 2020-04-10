package com.yyrj.cloud_note.service;

import java.util.List;

import com.yyrj.cloud_note.entity.Share;
import com.yyrj.cloud_note.util.NoteResult;

public interface ShareService {
	public NoteResult<Share> insert(String noteId);
	public NoteResult<List<Share>> search(String keyword,int page);
}
