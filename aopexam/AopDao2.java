package com.aopexam;

import org.springframework.stereotype.Repository;

@Repository
public class AopDao2 {
	public String test01(String id, String pw) {
		return null;
	}
	
	public boolean test02() {
		return false;
	}
	
	public int test03(String email, String pw) { //자료형 Integer로 하면 LogAdvisor2에서 리턴 안 해줘도 됨(void 가능)
		return 1;
	}
}
