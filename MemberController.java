package com.mvcproject.member.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mvcproject.member.controller.model.dao.MemberDao;
import com.mvcproject.member.controller.model.vo.Member;

@Controller
public class MemberController {
	@Autowired //이걸 쓰면 spring이 생성해서 객체를 담아주기 때문에 new MemberDao를 안해도 됨
	MemberDao memberDao;
	
	@RequestMapping(value="memberList.do", method=RequestMethod.GET)
	public ModelAndView memberListService(ModelAndView modelAndView) throws Exception{
		List<Member> memberList = memberDao.selectMemberAll();
		
		for(int i = 0; i<memberList.size(); i++) {
			System.out.println(i);
		}
		
		//modelAndView.addObject("memberList", memberList);
		modelAndView.setViewName("member/memberList");
		return modelAndView;
	}
}
