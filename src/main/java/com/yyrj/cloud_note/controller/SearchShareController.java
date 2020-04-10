package com.yyrj.cloud_note.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyrj.cloud_note.entity.Share;
import com.yyrj.cloud_note.service.ShareService;
import com.yyrj.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/share")
public class SearchShareController {
	@Resource
	private ShareService service;
	
	@RequestMapping("/search.do")
	@ResponseBody
	public NoteResult<List<Share>> searchShare(String keyword,int page)
	{
		NoteResult<List<Share>> result=service.search("%"+keyword+"%",page);
		return result;
	}
}
