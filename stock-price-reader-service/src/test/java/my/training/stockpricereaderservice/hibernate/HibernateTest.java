package my.training.stockpricereaderservice.hibernate;

import java.util.Date;

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
		userdetails.setUserid("1");
		
		userdetails.setUserName("first user");
		userdetails.setAdddress("first  addtress ");
		userdetails.setDescription("first user descriptn");
		userdetails.setJoinedDate(new Date());
		
		
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		session.save(userdetails);
		session.getTransaction().commit();
		session.close();
		
		//Read data from db
		userdetails=null;
		session= sessionFactory.openSession();
		session.beginTransaction();
		userdetails =session.get(Userdetails.class, "1");
		
		System.out.println("USER_DET"+userdetails.getUserName());
		

	}

}
