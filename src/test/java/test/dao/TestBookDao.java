package test.dao;

import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yyrj.cloud_note.dao.BookDao;
import com.yyrj.cloud_note.entity.Notebook;
import com.yyrj.cloud_note.entity.User;

public class TestBookDao {
	@Test
	public void test1()
	{
		String[] conf={"conf/spring-mybatis.xml","conf/spring-mvc.xml"};
		ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
		BookDao dao=ac.getBean("bookDao",BookDao.class);
		List<Notebook> list=dao.findByUserId("39295a3d-cc9b-42b4-b206-a2e7fab7e77c");
		for(Notebook book:list)
		{
			System.out.println(book);
		}
	}
}
