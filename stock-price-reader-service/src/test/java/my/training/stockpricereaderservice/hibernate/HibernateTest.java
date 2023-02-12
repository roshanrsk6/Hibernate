package my.training.stockpricereaderservice.hibernate;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.training.stockpricereaderservice.model.Address;
import my.training.stockpricereaderservice.model.Stock;
import my.training.stockpricereaderservice.model.Userdetails;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Userdetails userdetails=new Userdetails();
		
		userdetails.setUserName("first user");
		userdetails.setDescription("first user descriptn");
		userdetails.setJoinedDate(new Date());
		Address address=new Address();
		address.setCity("first city");
		address.setPincode("first pin");
		address.setState("first state");
		address.setStreet("first street");
		//userdetails.setHomeAddress(address);
		userdetails.getListOfAddress().add(address);
		Address address12=new Address();
		address12.setCity("first city");
		address12.setPincode("first pin");
		address12.setState("first state");
		address12.setStreet("first street");
		userdetails.getListOfAddress().add(address12);
		
		
		Userdetails userdetails2=new Userdetails();
		
		userdetails2.setUserName("scond user");
		userdetails2.setDescription("scond user descriptn");
		userdetails2.setJoinedDate(new Date());
		Address address2=new Address();
		address2.setCity("socnd city");
		address2.setPincode("socnd pin");
		address2.setState("socnd state");
		address2.setStreet("socnd street");
		//userdetails2.setHomeAddress(address2);
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		
		
		session.save(userdetails);
		//session.save(userdetails2);
		session.getTransaction().commit();
		session.close();
		
		//Read data from db
		userdetails=null;
		session= sessionFactory.openSession();
		session.beginTransaction();
		userdetails =session.get(Userdetails.class, 1);
		session.close();
		userdetails.getListOfAddress();
		
		System.out.println("USER_DET"+userdetails.getUserName());
		

	}

}
