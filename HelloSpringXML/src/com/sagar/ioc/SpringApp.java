package com.sagar.ioc;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		configuration for spring container
		
//		Steps 1. configure Spring Beans.
//		Step 2. Create spring Container
//		step 3. Retreive Beans from the container
//		loading the spring configuration file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		reterive bean from the spring container
		
//		Coach theCoach = context.getBean("theFootBallCoach", Coach.class);
//		System.out.println(theCoach.getDailyWorkout());
//		System.out.println(theCoach.getDailyFortune());
		
		Coach theCoach = context.getBean("mycrickcoach", Coach.class);
		System.out.println(theCoach.getDailyWorkout());
		System.out.println(theCoach.getDailyFortune());
		context.close();
	}
}
