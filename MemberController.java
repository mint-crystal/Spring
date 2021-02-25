package com.mvcproject.member.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
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
		
//		for(int i = 0; i<memberList.size(); i++) {
//			//System.out.println(i);
//			Member member = memberList.get(i);
//			System.out.println(i+"name : "+member.getName());
//		}
		
		modelAndView.addObject("memberList", memberList);
		modelAndView.setViewName("member/memberList");
		return modelAndView;
	}
	
	@RequestMapping(value="memberView.do", method=RequestMethod.GET)
	public String memberViewService(@RequestParam("id") String id, Model model, HttpServletRequest request) throws Exception {
		Member member = memberDao.selectMember(id);
		model.addAttribute("member",member);
		return "member/memberView";
	}
	
	//RequestMapping을 아래와 같이 사용하기도 함
	// @GetMapping("memberDel.do") / @PostMapping
	@RequestMapping(value="memberDel.do", method=RequestMethod.GET)
	public ModelAndView deleteMember(Member member, ModelAndView modelAndView) throws Exception {
		int cnt = memberDao.deleteMember(member);
		
		modelAndView.addObject("cnt", cnt);
		modelAndView.setViewName("member/memberDelComplete");
		
		return modelAndView;
	}
	
	@RequestMapping(value="memberInsert.do", method=RequestMethod.POST)
	public ModelAndView insertMember(Member member, ModelAndView modelAndView) throws Exception {
		int cnt = memberDao.insertMember(member);
		
		modelAndView.addObject("cnt", cnt);
		modelAndView.setViewName("member/memberInsComplete");
		
		return modelAndView;
	}
	
	@RequestMapping(value="memberUpdate.do", method=RequestMethod.POST)
	public ModelAndView updateMember(Member member, ModelAndView modelAndView) throws Exception {
		int cnt = memberDao.updateMember(member);
		
		modelAndView.addObject("cnt", cnt);
		modelAndView.setViewName("member/memberUptComplete");
		
		return modelAndView;
	}
}
