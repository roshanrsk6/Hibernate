package my.training.stockpricereaderservice.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.SelectBeforeUpdate;

@Entity
@NamedQuery(name = "Userdetails.byId",query = "from Userdetails where userid=:userid")
@NamedNativeQuery(name ="Userdetails.byname" ,query = "select * form user_details where user_name=?",resultClass = Userdetails.class)
@Table(name = "USER_DETAILS")
@SelectBeforeUpdate(value = true)
@Cacheable
@Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Userdetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;

	@Column(name = "USER_NAME")
	private String userName;

	
	@ManyToMany(cascade = CascadeType.PERSIST)
	private Collection<Vehicle> vehcleList = new ArrayList();

	public int getUserid() {
		return userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Collection<Vehicle> getVehcleList() {
		return vehcleList;
	}

	public void setVehcleList(Collection<Vehicle> vehcleList) {
		this.vehcleList = vehcleList;
	}

}
