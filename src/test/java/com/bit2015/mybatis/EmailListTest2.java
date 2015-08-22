package com.bit2015.mybatis;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit2015.mybatis.dao.EmailListDao;
import com.bit2015.mybatis.vo.EmailListVo;

public class EmailListTest2 {
	
	private ApplicationContext factory;
	
	@Before
	public void setup() {
		factory = 
			new ClassPathXmlApplicationContext( "applicationContext.xml" );
		EmailListDao dao =  
				( EmailListDao ) factory.getBean( "emailListDao" );
		
//		dao.deleteAll();
//		dao.insert();
	}
	
	@After
	public void clear() {
//		dao.deleteAll();
	}
	
	@Test
	public void testGetList1() {
		EmailListDao dao =  
				( EmailListDao ) factory.getBean( "emailListDao" );

		List<EmailListVo> list = dao.getList();
		assertNotNull("조회결과 null", list);
	}
	
	@Test
	public void testGetList2() {
		EmailListDao dao =  
				( EmailListDao ) factory.getBean( "emailListDao" );

		List<EmailListVo> list = dao.getList();
		assertTrue( list.size() > 0 ); 
	}
	
	@Test
	public void testGetList3() {
		EmailListDao dao =  
				( EmailListDao ) factory.getBean( "emailListDao" );

		List<EmailListVo> list = dao.getList();
		assertEquals(10, list.size()); 
	}	
}
