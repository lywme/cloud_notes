package com.yyrj.cloud_note.dao;

import java.util.List;

import com.yyrj.cloud_note.entity.Notebook;

public interface BookDao {
	public List<Notebook> findByUserId(String userid);
	public int save(Notebook book);
}
