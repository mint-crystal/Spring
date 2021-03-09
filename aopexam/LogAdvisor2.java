package com.aopexam;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAdvisor2 {
	@Pointcut("execution(* com.aopexam.AopDao2.*(..))")
	public void perfCheck() {}

	@Around("perfCheck()")
	public Object performance(ProceedingJoinPoint jp) { //boolean과 int도 동작되게 하기 위해 Object로 설정하여 리턴값을 처리해야함
		long startTime = System.currentTimeMillis(); //1000이 오면 1초, 500이 오면 0.5초
		Object returnObj = null;
		try {
			returnObj = jp.proceed(); //리턴된 데이터를 받음?
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long endTime = System.currentTimeMillis();

		System.out.println(endTime - startTime);
		return returnObj;
	}
}
