package test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yyrj.cloud_note.entity.Notebook;
import com.yyrj.cloud_note.service.BookService;
import com.yyrj.cloud_note.util.NoteResult;

public abstract class TestBase {
	public ApplicationContext getAC()
	{
		String[] conf={"conf/spring-mybatis.xml","conf/spring-mvc.xml"};
		ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
		return ac;
	}
}
