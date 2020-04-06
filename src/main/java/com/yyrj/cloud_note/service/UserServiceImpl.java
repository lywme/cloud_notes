package com.yyrj.cloud_note.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.yyrj.cloud_note.dao.UserDao;
import com.yyrj.cloud_note.entity.User;
import com.yyrj.cloud_note.util.NoteResult;
import com.yyrj.cloud_note.util.NoteUtil;

@Service("userService") //ɨ���spring����
public class UserServiceImpl implements UserService {

	@Resource
	private UserDao userDao;
	
	public NoteResult<User> checkLogin(String name, String password) {
		//���ս������
		NoteResult<User> result=new NoteResult<User>();
		//����name��ѯ���ݿ�
		User user=userDao.findByName(name);
		
		//����û���
		if(user==null)
		{
			//0�����¼�ɹ�����0����ʧ��
			result.setStatus(1);
			result.setMsg("�û���������");
			return result;
		}
		
		//�������
		String md5Password=NoteUtil.md5(password);
		if(!user.getCn_user_password().equals(md5Password))
		{
			//���벻��ȷ
			result.setStatus(2);
			result.setMsg("�������");
			return result;
		}
		
		//�û��������붼��ȷ
		result.setStatus(0);
		result.setMsg("��¼�ɹ�");
		result.setData(user);
		return result;
	}

	public NoteResult addUser(String name,String password,String nickname) {

		NoteResult<Object> result=new NoteResult();
		if(name==null||password==null||nickname==null)
		{
			result.setStatus(2);
			result.setMsg("û�д�����Ӧ����");
			return result;
		}
		else
		{
			//����û�
			User user=userDao.findByName(name);
			
			
			if(user!=null)
			{
				//�û��Ѵ���
				result.setStatus(1);
				result.setMsg("�û����Ѵ���");
				return result;
			}
			else
			{
				User newuser=new User();
				newuser.setCn_user_name(name);
				newuser.setCn_user_nick(nickname);
				//���Բ������û�
				String uuid=NoteUtil.createId();
				newuser.setCn_user_id(uuid);
				String md5pwd=NoteUtil.md5(password);
				newuser.setCn_user_password(md5pwd);
				userDao.save(newuser);
				result.setStatus(0);
				result.setMsg("�������û��ɹ�");
				return result;
			}
			
		}
	}

}
