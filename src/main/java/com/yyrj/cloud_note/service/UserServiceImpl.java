package com.yyrj.cloud_note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yyrj.cloud_note.dao.UserDao;
import com.yyrj.cloud_note.entity.User;
import com.yyrj.cloud_note.util.NoteResult;
import com.yyrj.cloud_note.util.NoteUtil;

@Service("userService") //扫描的spring容器
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	public NoteResult<User> checkLogin(String name, String password) {
		//接收结果数据
		NoteResult<User> result=new NoteResult<User>();
		//按照name查询数据库
		User user=userDao.findByName(name);
		
		//检测用户名
		if(user==null)
		{
			//0代表登录成功，非0代表失败
			result.setStatus(1);
			result.setMsg("用户名不存在");
			return result;
		}
		
		//检测密码
		String md5Password=NoteUtil.md5(password);
		if(!user.getCn_user_password().equals(md5Password))
		{
			//密码不正确
			result.setStatus(2);
			result.setMsg("密码错误");
			return result;
		}
		
		//用户名和密码都正确
		result.setStatus(0);
		result.setMsg("登录成功");
		result.setData(user);
		return result;
	}

	public NoteResult addUser(String name,String password,String nickname) {

		NoteResult<Object> result=new NoteResult();
		if(name==null||password==null||nickname==null)
		{
			result.setStatus(2);
			result.setMsg("没有传入相应参数");
			return result;
		}
		else
		{
			//检查用户
			User user=userDao.findByName(name);
			
			
			if(user!=null)
			{
				//用户已存在
				result.setStatus(1);
				result.setMsg("用户名已存在");
				return result;
			}
			else
			{
				User newuser=new User();
				newuser.setCn_user_name(name);
				newuser.setCn_user_nick(nickname);
				//可以插入新用户
				String uuid=NoteUtil.createId();
				newuser.setCn_user_id(uuid);
				String md5pwd=NoteUtil.md5(password);
				newuser.setCn_user_password(md5pwd);
				userDao.save(newuser);
				result.setStatus(0);
				result.setMsg("插入新用户成功");
				return result;
			}
			
		}
	}

}
