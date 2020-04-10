package com.yyrj.cloud_note.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yyrj.cloud_note.dao.NoteDao;
import com.yyrj.cloud_note.dao.ShareDao;
import com.yyrj.cloud_note.entity.Note;
import com.yyrj.cloud_note.entity.Share;
import com.yyrj.cloud_note.util.NoteResult;
import com.yyrj.cloud_note.util.NoteUtil;

@Service("shareService")
public class ShareServiceImpl implements ShareService {
	@Resource
	private ShareDao dao;
	@Resource
	private NoteDao noteDao;
	
	public NoteResult<Share> insert(String noteId) {
		//先根据传入的noteId获得对应的Note
		Note note=noteDao.findByNoteId(noteId);
		//构建Share
		Share s=new Share();
		s.setCn_note_id(note.getCn_note_id());
		s.setCn_share_title(note.getCn_note_title());
		s.setCn_share_body(note.getCn_note_body());
		s.setCn_share_id(NoteUtil.createId());
		NoteResult<Share> result=new NoteResult<Share>();
		
		dao.insert(s);
		result.setStatus(0);
		result.setMsg("分享笔记成功");
		result.setData(s);
		return result;
	}

	public NoteResult<List<Share>> search(String keyword,int page) {
		NoteResult<List<Share>> result=new NoteResult<List<Share>>();
		Map<String,Object> params=new HashMap();
		//计算记录分页的起点
		int begin=(page-1)*3;
		params.put("keyword", keyword);
		params.put("begin",begin);
		List<Share> list=dao.search(params);
		result.setStatus(0);
		result.setMsg("查询成功");
		result.setData(list);
		return result;
	}

}
