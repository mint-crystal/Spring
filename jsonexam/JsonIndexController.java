package com.mvc.jsonexam;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class JsonIndexController {
	
	@RequestMapping(value="jsontest.do", method=RequestMethod.GET)
	public String jsontest() {
		return "jsontest/test";
	}
}
