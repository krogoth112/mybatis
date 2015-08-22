package com.bit2015.mybatis.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2015.mybatis.vo.EmailListVo;


@Repository
public class EmailListDao {

	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	
	public void insert( EmailListVo vo ) {
		sqlSessionTemplate.insert( "emaillist.insert", vo );
	}
	
	public List<EmailListVo> getList() {
		List<EmailListVo> list = sqlSessionTemplate.selectList( "emaillist.list" );
		return list;
	}
}