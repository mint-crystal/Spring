package com.mvc.exam;

import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageController {
	
	/* 문제1)
	 * MessageController 를 만들고 message.do , get 방식으로 두개의 값을 넘겨서 
	 * {'data1', '홍길동'}, {'data2', 10}  message.jsp 에서 출력하시오.​ */
	
	/* 문제2)
	 * MessageController에서 추가로 현재 날짜 값을 넘기고 
	 * jstl의 fmt를 이용해서 날짜를 출력하시오. */
	
	@RequestMapping(value = "/message.do", method = RequestMethod.GET)
	public ModelAndView index(ModelAndView modelAndView) {
		Date date = new Date();
		
		modelAndView.addObject("data1", "홍길동");
		modelAndView.addObject("data2", 10);
		modelAndView.addObject("data3", date);
		
		modelAndView.setViewName("message");
		
		
		
		return modelAndView;
	}
}
