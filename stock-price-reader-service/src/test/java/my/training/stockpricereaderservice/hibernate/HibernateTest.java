package my.training.stockpricereaderservice.hibernate;

import java.util.Iterator;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.training.stockpricereaderservice.model.FourWheeler;
import my.training.stockpricereaderservice.model.TwoWheeler;
import my.training.stockpricereaderservice.model.Userdetails;
import my.training.stockpricereaderservice.model.Vehicle;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		
		
		
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		
		Userdetails userdetails= session.get((Userdetails.class), 3);
		session.close();
		
		
		userdetails.setUserName("update afetr sesson clsse");
		
		session= sessionFactory.openSession();
		session.beginTransaction();
		
		session.update(userdetails);
		session.getTransaction().commit();
		session.close();
		
	}

}
