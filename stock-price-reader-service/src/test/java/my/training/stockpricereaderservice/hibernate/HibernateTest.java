package my.training.stockpricereaderservice.hibernate;

import java.util.Date;

import javax.persistence.Basic;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.training.stockpricereaderservice.model.Userdetails;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Userdetails userdetails=new Userdetails();
		userdetails.setUserid("3");
		
		userdetails.setUserName("second user");
		userdetails.setAdddress("secind  addtress ");
		userdetails.setDescription("secdnd user descriptn");
		userdetails.setJoinedDate(new Date());
		
		
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.save(userdetails);
		session.getTransaction().commit();
		

	}

}
