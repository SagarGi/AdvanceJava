package com.sagar.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanLifeCycle {
	
	public static void main(String args[])
	{
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanLifeCycleContext.xml");
		FootBallCoach theCoach = context.getBean("footballcoach", FootBallCoach.class);
		System.out.println(theCoach.getDailyWorkout());
		context.close();
	}

}
