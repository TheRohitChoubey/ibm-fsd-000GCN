package cd_type_webapp.factory;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class InstructorFactory {
	private static SessionFactory factory = null;
	private static Session session = null;
	static {
		factory = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
	}

	public static Session getMySession() {
		session = factory.openSession();
		return session;
	}

}
