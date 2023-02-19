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
		
		
		//create multiple user
		
		for (int i = 0; i < 5; i++) {
		
			Userdetails userdetails=new Userdetails();
			userdetails.setUserName("User:"+i);
			session.save(userdetails);
		}
	/// get users
		
		Userdetails userdetails= session.get(Userdetails.class, 1);
		System.out.println("fetched user"+userdetails.getUserName());
		//
		//delete user
		session.delete(userdetails);
		//update
		Userdetails userdetails2= session.get(Userdetails.class, 2);
		userdetails2.setUserName("updated user");
		session.update(userdetails2);
		System.out.println("updated user"+userdetails2.getUserName());
		
		session.getTransaction().commit();
		session.close();
		
	}

}
