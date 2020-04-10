package test.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yyrj.cloud_note.dao.BookDao;
import com.yyrj.cloud_note.dao.ShareDao;
import com.yyrj.cloud_note.entity.Notebook;
import com.yyrj.cloud_note.entity.Share;

public class TestShareDao {
	@Test
	public void test1()
	{
		String[] conf={"conf/spring-mybatis.xml","conf/spring-mvc.xml"};
		ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
		ShareDao dao=ac.getBean("shareDao",ShareDao.class);
		
		Share share=new Share();
		share.setCn_note_id("test");
		share.setCn_share_body("test");
		share.setCn_share_id("test");
		share.setCn_share_title("test");
		dao.insert(share);
	}
	
	@Test
	public void test2()
	{
		String[] conf={"conf/spring-mybatis.xml","conf/spring-mvc.xml"};
		ApplicationContext ac=new ClassPathXmlApplicationContext(conf);
		ShareDao dao=ac.getBean("shareDao",ShareDao.class);
		
		Map<String,Object> params=new HashMap();
		params.put("keyword", "%≤‚ ‘%");
		params.put("begin",1);
		List<Share> list=dao.search(params);
		for(Share s:list)
		{
			System.out.println(s);
		}
	}
}
