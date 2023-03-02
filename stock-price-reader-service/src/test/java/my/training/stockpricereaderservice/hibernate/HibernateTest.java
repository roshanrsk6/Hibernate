package my.training.stockpricereaderservice.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

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
		String userid="9";
		String username="updated user 9";
		Query query= session.createQuery("from  Userdetails where userid>? and username=? ");
		
		query.setInteger(0, Integer.parseInt(userid));
		query.setString(1, username);
		
		 query= session.createQuery("from  Userdetails where userid>:userid and username=:username ");
		query.setInteger("userid", Integer.parseInt(userid));
		query.setInteger("username", Integer.parseInt(userid));
		
		
		query= session.createNamedQuery("Userdetails.byId");
		query.setInteger("userid", Integer.parseInt(userid));
		
		Criteria criteria= session.createCriteria(Userdetails.class);
		Criterion c1= Restrictions.eq("username", "user 10");
		Criterion c2= Restrictions.eq("username", "user 10");
		Criterion c3=Restrictions.or(c1,c2);
		criteria.add(c3);
		
		
		
		
		criteria.add(
			Restrictions.eq("username", "user 10"))
				.add(Restrictions.ge("userid", 10));
		
		
		
		query.setFirstResult(0);
		query.setMaxResults(10);
		List<String> users= query.list();
		query.
		
		session.getTransaction().commit();
		session.close();
		
	
		users.stream().forEach(u->{
			System.out.println("result set:"+u);
		});
		
	}

}
