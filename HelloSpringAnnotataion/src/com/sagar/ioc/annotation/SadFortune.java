package com.sagar.ioc.annotation;

import org.springframework.stereotype.Component;

@Component
public class SadFortune implements FortuneService {

	@Override
	public String getFortune() {
		// TODO Auto-generated method stub
		return "Today is your unluckyday!!!";
	}

}
