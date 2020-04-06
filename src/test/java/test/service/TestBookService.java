package test.service;

import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yyrj.cloud_note.entity.Notebook;
import com.yyrj.cloud_note.service.BookService;
import com.yyrj.cloud_note.service.UserService;
import com.yyrj.cloud_note.util.NoteResult;

public class TestBookService {
	@Test
	public void test1()
	{
		String[] conf={"conf/spring-mybatis.xml","conf/spring-mvc.xml"};
		ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
		BookService service=ac.getBean("bookService",BookService.class);
		NoteResult<List<Notebook>> result=service.loadUserBooks("39295a3d-cc9b-42b4-b206-a2e7fab7e77c");
		System.out.println(result);
	}
}
