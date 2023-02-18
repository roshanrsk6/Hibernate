package my.training.stockpricereaderservice.hibernate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;

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
		
		
	
		Vehicle vehicle=new Vehicle();
		vehicle.setVehicleName("first user car");
		
		TwoWheeler twoWheeler=new TwoWheeler();
		twoWheeler.setSteeringHandle("twowheelrr handle");
		twoWheeler.setVehicleName("herohonda");
		
		FourWheeler fourWheeler=new FourWheeler();
		fourWheeler.setSteeringwheel("steerinf wheel");
		fourWheeler.setVehicleName("porshce");
		
		
		
		SessionFactory sessionFactory= new Configuration().configure().buildSessionFactory();
		Session session= sessionFactory.openSession();
		session.beginTransaction();
		
	
		
		session.save(vehicle);
		session.save(twoWheeler);
		session.save(fourWheeler);
		
		session.getTransaction().commit();
		session.close();
		
	}

}
