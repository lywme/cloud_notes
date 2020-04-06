package test.service;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yyrj.cloud_note.dao.UserDao;
import com.yyrj.cloud_note.entity.User;
import com.yyrj.cloud_note.service.UserService;
import com.yyrj.cloud_note.util.NoteResult;
import com.yyrj.cloud_note.util.NoteUtil;

public class TestUserService {
	private UserService service;
	
	@Before
	public void init()
	{
		String[] conf={"conf/spring-mybatis.xml","conf/spring-mvc.xml"};
		ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
		service=ac.getBean("userService",UserService.class);
	}
	
	@Test  //预期结果：用户名不存在
	public void test1()
	{
		NoteResult<User> result=service.checkLogin("aaa", "aaa");
		System.out.print(result);
	}
	
	@Test
	public void test2()
	{
		NoteResult<User> result=service.checkLogin("demo", "13456");
		System.out.print(result);
	}
	
	@Test
	public void test3()
	{
		NoteResult<User> result=service.checkLogin("demo", "123456");
		System.out.print(result);
	}
	
	@Test
	public void test4()
	{
		
		NoteResult<Object> result=service.addUser("lywme1","123456","Darren");
		System.out.print(result);
	}
}
