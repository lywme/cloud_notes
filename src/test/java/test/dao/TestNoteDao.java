package test.dao;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.yyrj.cloud_note.dao.NoteDao;
import com.yyrj.cloud_note.entity.Note;
import com.yyrj.cloud_note.service.UserService;

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
}
