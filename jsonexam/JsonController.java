package com.mvc.jsonexam;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class JsonController {
	
	private static final Logger logger = LoggerFactory.getLogger(JsonController.class);
	
	@RequestMapping(value="test1.do", method=RequestMethod.POST)
	public void test1Method(Sample vo, HttpServletResponse response, HttpSession session) throws IOException{
		response.setContentType("text/html; charset=utf-8"); 
		
		//PrintWriter 객체를 생성하여 통신에 대한 응답 결과를 전달한다.
		PrintWriter out = response.getWriter();
		
		System.out.println(vo.getName());
		System.out.println(vo.getAge());
		
		if(vo.getName().equals("신사임당")) {
			//session.setAttribute("sample", vo);
			out.append("ok");
			out.flush(); //위 데이터를 전달?
		}else {
			out.append("fail");
			out.flush();
		}
		out.close();
	}
	
	@RequestMapping(value="test2.do", method=RequestMethod.POST)
	@ResponseBody //결과를 response 객체에 담아서 보내는 어노테이션
	public String test2Method(HttpServletResponse response) throws IOException{
		response.setContentType("application/json; charset=utf-8");
		
		JSONObject job = new JSONObject();
		//Map 형식의 JSONObject 객체를 생성하여 출력할 값을 Key와 Value 형태로 담는다.
		job.put("no", 123);
		job.put("title", "test return json object");
		//한글 전송시 깨질 우려가 있으므로 URLEncoder로 UTF-8방식의 인코딩을 처리한다.
		job.put("writer", URLEncoder.encode("홍길동", "utf-8"));
		job.put("content", URLEncoder.encode("json객체를 뷰로 리턴하는 테스트", "utf-8"));
		
		//JSONObject를 String형태로 리턴
		return job.toJSONString();
	}
	
	@RequestMapping(value="test3.do", method=RequestMethod.POST)
	public void test3Method(HttpServletResponse response) throws IOException{
		//List를 json 배열로 만들어서, 뷰를 리턴처리한다.
		ArrayList <User> list = new ArrayList<User>();
		list.add(new User("u1234", "p1234", "홍길동", 25, "h1234@kh.org"));
		list.add(new User("u2345", "p2345", "박문수", 33, "p2345@kh.org"));
		list.add(new User("u3456", "p3456", "장영실", 45, "j3456@kh.org"));
		
		//전송용 최종 json 객체
		JSONObject sendJson = new JSONObject();
		//JSONArray 객체를 생성하여 JSONObject 객체를 하나씩 담는다
		JSONArray jarr = new JSONArray();
		
		//list를 jarr에 저장처리
		for(User user:list) {
			//user 정보 저장할 json 객체 선언
			JSONObject juser = new JSONObject();
			juser.put("userId", user.getUserId());
			juser.put("userPwd", user.getUserPwd());
			juser.put("userName", URLEncoder.encode(user.getUserName(),"utf-8"));
			juser.put("age", user.getAge());
			juser.put("email", user.getEmail());
			jarr.add(juser);
		}
		
		//전송할 객체 배열을 JSONObject에 담아 한 번에 전달한다
		sendJson.put("list", jarr);
		response.setContentType("application/json; charset=utf-8");
		PrintWriter out = response.getWriter();
		out.println(sendJson.toJSONString());
		out.flush();
		out.close();
	}
	
	@RequestMapping(value="test4.do", method=RequestMethod.POST)
	public ModelAndView test4Method(ModelAndView mav) throws UnsupportedEncodingException{
		Sample sample = new Sample();
		sample.setName("신사임당");
		sample.setAge("40");
		
		//저장된 이름을 가져와 인코딩하여 새로 생성
		sample.setName(URLEncoder.encode(sample.getName(),"utf-8"));
		
		//맵을 생성하여 객체를 담아줌
		Map<String, Sample> map = new HashMap<String, Sample>();
		map.put("sample", sample);
		
		//map데이터를 viewResolver가 json화해서 보내줌
		//map에 하나 이상의 object(데이터)가 담기므로 addAllObjects를 사용
		mav.addAllObjects(map);	//jsonView로 이동하여 map데이터를 json으로 만들어준다?
		//뷰지정 : jsonView를 빈으로 등록하고, 객체의 id를 뷰이름으로 지정해야 함
		mav.setViewName("jsonView");
		return mav;	//ajax 는 json 객체로 받음
	}
	
	@RequestMapping(value="test5.do", method=RequestMethod.POST)
	public ResponseEntity<String> test5Method(HttpServletRequest request, 
			@RequestBody String param) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		//전송받은 문자열을 json 객체로 변환 처리
		JSONParser parser = new JSONParser();
		JSONObject job = (JSONObject)parser.parse(param);
		
		String name = (String)job.get("name");
		int age = ((Long)job.get("age")).intValue();
		
		//정상 완료됨을 클라이언트로 성공 값을 보내야 함
		return new ResponseEntity<String>("succes", HttpStatus.OK);
	}
	
	@RequestMapping(value="test6.do", method=RequestMethod.POST)
	@ResponseBody
	public ResponseEntity<String> test6Method(HttpServletRequest request,
			@RequestBody String param) throws Exception{
		request.setCharacterEncoding("utf-8");
		
		JSONArray jarr = (JSONArray)new JSONParser().parse(param);
		
		for(int i = 0; i<jarr.size(); i++) {
			JSONObject job = (JSONObject)jarr.get(i);
			String name = (String)job.get("name");
			int age = ((Long)job.get("age")).intValue();		
		}
		
		//성공 값 전송
		return new ResponseEntity<String>("success",HttpStatus.OK);
	}
}
