package hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {
	
	static Session session=null;
	
	public static Session getSession()
	{
		SessionFactory sessionfactory;
	
			Configuration config=new Configuration();
			config.configure("Hibernate.cfg.xml");
			sessionfactory=config.buildSessionFactory();
			session=sessionfactory.openSession();
		return session;
	}

}
