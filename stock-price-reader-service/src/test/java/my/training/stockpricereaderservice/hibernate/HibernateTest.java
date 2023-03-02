package my.training.stockpricereaderservice.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.training.stockpricereaderservice.model.Userdetails;

public class HibernateTest {

	/**
	 * @param args
	 */
	@SuppressWarnings("deprecation")
	public static void main(String[] args) {
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		
		//caching first lvel
				Userdetails userdetails= session.get(Userdetails.class, 1);
				Userdetails userdetails2= session.get(Userdetails.class, 1);
				//if data fetched within the same seion with same inout the only one 
		session.close();
		
		Session session2= sessionFactory.openSession();
		session2.beginTransaction();
		
		Userdetails ud= session2.get(Userdetails.class, 1);
		session2.close();
		
				
		
		
		
	}

}
