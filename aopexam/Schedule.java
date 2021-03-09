package com.aopexam;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Schedule {
	@Scheduled(fixedRate=1000)
	public void scheduleTask() {
		System.out.println("schedule test");
	}
}
