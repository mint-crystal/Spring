package com.mvcproject.member.controller.model.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mvcproject.member.controller.model.vo.Member;

@Repository //보통 DAO 위에 붙여 사용한다. 클래스를 자동으로 만들어주는?
public class MemberDao {
	@Autowired //DI
	private SqlSessionTemplate sqlSession; 
	
	public MemberDao() {}
	
	public List<Member> selectMemberAll() throws Exception{
		//메소드명은 xml에서 설정한 id와 같은 이름을 사용하나 보안에 취약할 수 있음
		List<Member> memberList = sqlSession.selectList("Member.selectMemberAll"); //namespace.가져올 쿼리
		return memberList;
	}
}
