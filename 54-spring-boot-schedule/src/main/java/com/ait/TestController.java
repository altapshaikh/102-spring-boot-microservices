package com.ait;

import java.util.Calendar;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class TestController {
	int count=1;
@Scheduled(fixedRate = 3000)
	public String getmsg() {
	System.out.println(new Date().getSeconds());
	System.out.println("hi");
	System.out.println(new Date().getSeconds());
		return "test";
	}
}
