package com.yyrj.cloud_note.util;

import java.security.MessageDigest;
import java.util.UUID;

import org.apache.tomcat.util.codec.binary.Base64;

import com.yyrj.cloud_note.NoteException;

public class NoteUtil {
	public static String md5(String src) throws NoteException
	{
		try
		{
			MessageDigest md=MessageDigest.getInstance("MD5");
			//MD5���ܴ���
			byte[] output=md.digest(src.getBytes());
			//Base64����
			String ret=Base64.encodeBase64String(output);
			return ret;
		}
		catch(Exception e)
		{
			throw new NoteException("�������ʧ��",e);
		}
	}
	
	//����uuid�㷨��������
	public static String createId()
	{
		UUID uuid=UUID.randomUUID();
		String id=uuid.toString();
		//ȥ��uuid�е� ����-
		return id.replace("-", "");
	}
	
	public static void main(String[] args) throws NoteException {
		// TODO Auto-generated method stub
		System.out.println(md5(createId()));
		System.out.println(createId());
	}

}
