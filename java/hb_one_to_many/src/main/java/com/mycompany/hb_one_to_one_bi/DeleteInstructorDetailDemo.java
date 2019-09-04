package com.mycompany.hb_one_to_one_bi;
import org.hibernate.*;
import org.hibernate.cfg.Configuration;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {			
			session.beginTransaction();
			int theId = 2;
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			System.out.println("tempInstructorDetail: " + tempInstructorDetail);
			System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());
			System.out.println("Deleting tempInstructorDetail: "+ tempInstructorDetail);
			session.delete(tempInstructorDetail);
			session.getTransaction().commit();
			System.out.println("Done!");
		}
		catch (Exception exc) {
			exc.printStackTrace();
		}
		finally {
			session.close();
			factory.close();
		}
	}

}





