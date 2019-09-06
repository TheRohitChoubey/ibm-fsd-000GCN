package com.IBm._myfirstSpring_Project;


import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.IBm._myfirstSpring_Project.beans.*;

class App 
{
    public static void main( String[] args )
    {
        try {
        	
        	ClassPathXmlApplicationContext context=new 
        			ClassPathXmlApplicationContext("applicationContext.xml");
        	Coach myCoach=context.getBean("theCoach",BaseballCoach.class);
        	System.out.println(myCoach.getDailyWorkout());
        	Coach myCoach1=context.getBean("theCoach",BaseballCoach.class);
        	System.out.println(myCoach==myCoach1);
        	
        	context=new 
        			ClassPathXmlApplicationContext("applicationContext1.xml");
        	Fortune myFortune=context.getBean("thelucky",FortuneServiceImpl.class);
        	System.out.println(myFortune.toString());
        	
        	CricketCoach cs = context.getBean("theCricket",CricketCoach.class);
        	
        	System.out.println(cs.toString());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
    }
}