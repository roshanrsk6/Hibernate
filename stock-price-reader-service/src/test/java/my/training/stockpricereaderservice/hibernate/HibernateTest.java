package my.training.stockpricereaderservice.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import my.training.stockpricereaderservice.model.Userdetails;
import my.training.stockpricereaderservice.model.Vehicle;

public class HibernateTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Userdetails userdetails=new Userdetails();
		
		userdetails.setUserName("first user");
		
	
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleName("first user car");
		vehicle.getUserlist().add(userdetails);
		
		userdetails.getVehcleList().add(vehicle);		
		
		Userdetails userdetails2=new Userdetails();
		userdetails2.setUserName("secnd user");
		
		Vehicle vehicle2=new Vehicle();
		vehicle2.setVehicleName("first user send car");
		vehicle2.getUserlist().add(userdetails2);
		vehicle2.getUserlist().add(userdetails);
		userdetails2.getVehcleList().add(vehicle2);
		userdetails2.getVehcleList().add(vehicle);
		userdetails.getVehcleList().add(vehicle2);
		vehicle.getUserlist().add(userdetails2);
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		
	
		session.save(userdetails);
		session.save(vehicle);
		session.save(vehicle2);
		session.save(userdetails2);
		
		session.getTransaction().commit();
		session.close();
	
		Session getSession= sessionFactory.openSession();
		getSession.beginTransaction();
		Userdetails Userdetails2=  getSession.get(Userdetails.class, 1);
		
		
		System.out.println("USER_DET"+userdetails.getUserName());
		

	}

}
