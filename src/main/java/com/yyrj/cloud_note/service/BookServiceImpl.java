package com.yyrj.cloud_note.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yyrj.cloud_note.dao.BookDao;
import com.yyrj.cloud_note.entity.Notebook;
import com.yyrj.cloud_note.util.NoteResult;

@Service("bookService") //ɨ���spring����
public class BookServiceImpl implements BookService {
	@Resource
	private BookDao dao;

	public NoteResult<List<Notebook>> loadUserBooks(String userId) {
		NoteResult<List<Notebook>> result=new NoteResult<List<Notebook>>();
		List<Notebook> list=dao.findByUserId(userId);
		if(list.size()==0)
		{
			//û�бʼǱ�
			result.setStatus(1);
			result.setMsg("��ѯ�����ʼǱ�");
		}
		else
		{
			result.setStatus(0);
			result.setMsg("��ѯ����");
			result.setData(list);
		}
		return result;
	}

}
