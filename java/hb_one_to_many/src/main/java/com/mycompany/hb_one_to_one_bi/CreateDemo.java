package com.mycompany.hb_one_to_one_bi;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;



public class CreateDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		Session session = factory.getCurrentSession();
		
		try {	
			Instructor tempInstructor = 
					new Instructor("Madhu", "Patel", "madhu@luv2code.com");
			
			InstructorDetail tempInstructorDetail =new InstructorDetail("http://www.youtube.com","Guitar");	
			tempInstructor.setInstructorDetail(tempInstructorDetail);
			session.beginTransaction();
			System.out.println("Saving instructor: " + tempInstructor);
			session.save(tempInstructor);		
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

}





