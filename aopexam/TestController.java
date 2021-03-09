package com.aopexam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {
	@Autowired
	AopDao aopDao;
	
	@Autowired
	AopDao2 aopDao2;
	
	@RequestMapping("aop01.do")
	public void aop01() {
		aopDao.test01("1", "11");
		aopDao.test02(1);
		aopDao.test03("aa", "12");
	}
	
	@RequestMapping("aop02.do")
	public void aop02() {
		//aopDao2.test01("aa", "bb");
		aopDao2.test02();
		//aopDao2.test03("aa", "12");
	}
}
