package com.yedam.spring.java;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainExample {
	public static void main(String[] args) {
		ApplicationContext ctx =
				new GenericXmlApplicationContext("classpath:applicationContext.xml");
		
		//Restaurant res = (Restaurant)ctx.getBean("rs"); //id="" 값을 줬을때 사용 하는방법
		
		Restaurant res = (Restaurant)ctx.getBean(Restaurant.class); // id="" 값을 주지 않았을때 클래스 자체를 넣어 줘야한다
		res.run();
		
	}
}
