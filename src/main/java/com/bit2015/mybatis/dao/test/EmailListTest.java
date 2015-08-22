package com.bit2015.mybatis.dao.test;

import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bit2015.mybatis.dao.EmailListDao;
import com.bit2015.mybatis.vo.EmailListVo;

public class EmailListTest {
	public static void main(String[] args) {
		// 초기 작업
		ApplicationContext factory = 
			new ClassPathXmlApplicationContext( "applicationContext.xml" );
		EmailListDao dao =  
		( EmailListDao ) factory.getBean( "emailListDao" );
		
		// insert 테스트
		testInsert( dao );
			
		// getList 테스트
		testGetList( dao );
	}
	
	public static void testInsert( EmailListDao dao ) {
		EmailListVo vo = new EmailListVo();
		vo.setFirstName( "홍" );
		vo.setLastName( "길동" );
		vo.setEmail( "hongildong@gmail.com" );
	
		dao.insert(vo);
	}
	
	public static void testGetList( EmailListDao dao ){
		List<EmailListVo> list = dao.getList();
		
		for( EmailListVo vo : list ) {
			System.out.println(
			  vo.getNo() + ":" +
			  vo.getFirstName() + ":" +
			  vo.getLastName() + ":" +
			  vo.getEmail()
			);
		}
	}
}
