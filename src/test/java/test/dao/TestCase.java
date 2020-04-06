package test.dao;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yyrj.cloud_note.dao.UserDao;
import com.yyrj.cloud_note.entity.User;

public class TestCase {
	@Test
	public void test1()
	{
		ApplicationContext ac=new ClassPathXmlApplicationContext("conf/spring-mybatis.xml");
		UserDao dao=ac.getBean("userDao",UserDao.class);
		User user=dao.findByName("demo");
		System.out.print(user);
	}
	
	@Test
	public void test2()
	{
		String[] conf={"conf/spring-mybatis.xml","conf/spring-mvc.xml"};
		ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
		UserDao dao=ac.getBean("userDao",UserDao.class);
		User u=new User();
		u.setCn_user_id("20000");
		u.setCn_user_name("lywme");
		u.setCn_user_password("123");
		u.setCn_user_nick("Darren");

		dao.save(u);

	}
	
	
	
	
}
