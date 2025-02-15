package com.ait;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
public class test {
	@Autowired
	Environment env;

	public void env() {
		System.out.println(env.getProperty("my.active.profile"));
	}
}
