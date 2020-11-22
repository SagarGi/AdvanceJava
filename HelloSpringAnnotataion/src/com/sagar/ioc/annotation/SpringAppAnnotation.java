package com.sagar.ioc.annotation;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringAppAnnotation {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		configuration for spring container
		
//		Steps 1. configure Spring Beans.
//		Step 2. Create spring Container
//		step 3. Retreive Beans from the container
		
		
//		loading the spring configuration file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		reterive bean from the spring container
		
		FootBallCoach coach = context.getBean("footBallCoach", FootBallCoach.class);
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
		
		CricketCoach cricketCoach = context.getBean("cricketCoach", CricketCoach.class);
		System.out.println(cricketCoach.getDailyWorkout());
		System.out.println(cricketCoach.getDailyFortune());

		context.close();
	}

}
