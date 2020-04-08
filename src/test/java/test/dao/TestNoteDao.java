package test.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.yyrj.cloud_note.dao.NoteDao;
import com.yyrj.cloud_note.entity.Note;
import com.yyrj.cloud_note.service.UserService;
import com.yyrj.cloud_note.util.NoteUtil;

import test.TestBase;

public class TestNoteDao extends TestBase {
	private NoteDao dao;
	
	@Before
	public void init()
	{
		ApplicationContext ac= super.getAC();
		dao=ac.getBean("noteDao",NoteDao.class);
	}
	
	@Test
	public void test1()
	{
		List<Note> notes=dao.findByBookId("6d763ac9-dca3-42d7-a2a7-a08053095c08");
		for(Note n:notes)
		{
			System.out.println(n);
		}
	}
	
	@Test
	public void test2()
	{
		Note note=dao.findByNoteId("003ec2a1-f975-4322-8e4d-dfd206d6ac0c");
		System.out.println(note);
	}
	
	@Test
	public void test3()
	{
		Note n=new Note();
		n.setCn_note_title("Test Title");
		n.setCn_note_body("Test Body111");
		n.setCn_note_id("003ec2a1-f975-4322-8e4d-dfd206d6ac0c");
		n.setCn_note_last_modify_time(System.currentTimeMillis());
		int num=dao.updateNote(n);
		System.out.println(num);
	}
	
	@Test
	public void test4()
	{
		Note n=new Note();
		n.setCn_note_id(NoteUtil.createId());
		n.setCn_notebook_id("");
		n.setCn_user_id("39295a3d-cc9b-42b4-b206-a2e7fab7e77c");
		n.setCn_note_title("Test Title");
		n.setCn_note_last_modify_time(System.currentTimeMillis());
		n.setCn_note_create_time(System.currentTimeMillis());
		dao.save(n);
	}
}
