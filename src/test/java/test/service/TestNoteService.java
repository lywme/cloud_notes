package test.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;

import com.yyrj.cloud_note.service.NoteService;
import com.yyrj.cloud_note.util.NoteResult;

import test.TestBase;

public class TestNoteService extends TestBase {
	private NoteService service;
	
	@Before
	public void init()
	{
		ApplicationContext ac=super.getAC();
		service=ac.getBean("noteService",NoteService.class);
	}
	
	@Test
	public void test1()
	{
		NoteResult result=service.loadBookNotes("6d763ac9-dca3-42d7-a2a7-a08053095c08");
		System.out.println(result);
	}
	
	@Test
	public void test2()
	{
		NoteResult result=service.loadNote("003ec2a1-f975-4322-8e4d-dfd206d6ac0c");
		System.out.println(result);
	}
	
	@Test
	public void test3()
	{
		NoteResult result=service.addNote("test", "test", "test");
		System.out.println(result);
	}
}
