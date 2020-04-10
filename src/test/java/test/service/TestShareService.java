package test.service;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yyrj.cloud_note.entity.Share;
import com.yyrj.cloud_note.service.ShareService;
import com.yyrj.cloud_note.service.UserService;
import com.yyrj.cloud_note.util.NoteResult;

public class TestShareService {
	private ShareService service;
	
	@Before
	public void init()
	{
		String[] conf={"conf/spring-mybatis.xml","conf/spring-mvc.xml"};
		ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
		service=ac.getBean("shareService",ShareService.class);
	}
	
	@Test
	public void test1()
	{
		String noteId="88769b2903944cad9caee53ec0bbc72b";
		NoteResult<Share> result=service.insert(noteId);
		System.out.println(result);
	}
	
	@Test
	public void test2()
	{
		
		NoteResult<List<Share>> result=service.search("%≤‚ ‘%",1);
		System.out.println(result);
	}
}
