package com.yyrj.cloud_note.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yyrj.cloud_note.dao.BookDao;
import com.yyrj.cloud_note.entity.Notebook;
import com.yyrj.cloud_note.util.NoteResult;

@Service("bookService") //扫描的spring容器
public class BookServiceImpl implements BookService {
	@Resource
	private BookDao dao;

	public NoteResult<List<Notebook>> loadUserBooks(String userId) {
		NoteResult<List<Notebook>> result=new NoteResult<List<Notebook>>();
		List<Notebook> list=dao.findByUserId(userId);
		if(list.size()==0)
		{
			//没有笔记本
			result.setStatus(1);
			result.setMsg("查询不到笔记本");
		}
		else
		{
			result.setStatus(0);
			result.setMsg("查询正常");
			result.setData(list);
		}
		return result;
	}

}
