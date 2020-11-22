package com.sagar.ioc.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach{
	
	@Autowired
	@Qualifier("sadFortune")
	FortuneService fortuneService;
	public CricketCoach()
	{
		
	}
	
	public CricketCoach(FortuneService fortuneService)
	{
		this.fortuneService = fortuneService;
	}
	public void setFortuneService(FortuneService fortuneService)
	{
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		// TODO Auto-generated method stub
		return "Practise for one hour!!";
	}

	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
		return fortuneService.getFortune();
	}
	
//	using setter method injection
	
	
}
