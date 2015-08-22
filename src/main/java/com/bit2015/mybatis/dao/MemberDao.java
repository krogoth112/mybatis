package com.bit2015.mybatis.dao;

import java.util.HashMap;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit2015.mybatis.vo.MemberVo;

@Repository
public class MemberDao {
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;

	public MemberVo get( MemberVo vo ) {
		MemberVo memberVo = ( MemberVo ) sqlSessionTemplate.selectOne( "member.getMember", vo );
		return memberVo;
	}
	
	public MemberVo get( String email, String password ) {
		Map<String, String> map = new HashMap<String, String>();
		map.put( "email", email );
		map.put( "password", password );
		
		MemberVo vo = (MemberVo)sqlSessionTemplate.selectOne( "member.getMember", map );
		return vo;
	}
	
	//insert
	public void insert( MemberVo vo ) {
		sqlSessionTemplate.insert( "member.insert", vo );
	}		
	
}
