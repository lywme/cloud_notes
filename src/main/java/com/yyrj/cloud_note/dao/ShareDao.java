package com.yyrj.cloud_note.dao;

import java.util.List;
import java.util.Map;

import com.yyrj.cloud_note.entity.Share;

public interface ShareDao {
	public void insert(Share share);
	public List<Share> search(Map params);
}
