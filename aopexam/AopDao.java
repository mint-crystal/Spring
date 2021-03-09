package com.aopexam;

import org.springframework.stereotype.Repository;

@Repository
public class AopDao {
	public String test01(String id, String pw) {
		return null;
	}
	
	public boolean test02(int i) {
		return false;
	}
	
	public int test03(String email, String pw) {
		return 1;
	}
}
