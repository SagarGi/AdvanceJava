package com.sagar.ioc.annotation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.test.context.event.annotation.PrepareTestInstance;
import org.springframework.web.bind.annotation.PostMapping;

@Component
@Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class FootBallCoach implements Coach{
	
//	DI 1. constructor 2. setter (Injection methods)
	
	@Autowired //for injecting
	@Qualifier("happyFortune")
	private FortuneService fortuneService;
	
	public FootBallCoach()
	{
		
	}
	
//	injecting using constructor
	public FootBallCoach(FortuneService fortuneService)
	{
		this.fortuneService = fortuneService;
	}
	
//	using setter method injection
	
	public void setFortuneService(FortuneService fortuneService)
	{
		this.fortuneService = fortuneService;
	}
	
	
	public String getDailyWorkout()
	{
		return "Run for 30 min";
	}
	

	
	@Override
	public String getDailyFortune() {
		// TODO Auto-generated method stub
//		directly dependent!! making the fortune services class
		return fortuneService.getFortune();
	}
	
	
	public void initialize()
	{
		System.out.println("Bean Started!!!");
	}
	
	public void cleanUp()
	{
		System.out.println("Bean Cleaned !!!");
	}
}
