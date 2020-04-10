package com.yyrj.cloud_note.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yyrj.cloud_note.entity.Share;
import com.yyrj.cloud_note.service.ShareService;
import com.yyrj.cloud_note.util.NoteResult;

@Controller
@RequestMapping("/share")
public class ShareController {
	@Resource
	private ShareService service;
	
	@RequestMapping("/add.do")
	@ResponseBody
	public NoteResult<Share> addShare(String noteId)
	{
		NoteResult<Share> result=service.insert(noteId);
		return result;
	}
}
