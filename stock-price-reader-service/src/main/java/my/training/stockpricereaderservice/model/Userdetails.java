package my.training.stockpricereaderservice.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "USER_DETAILS")
public class Userdetails {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userid;

	@Column(name = "USER_NAME")
	private String userName;

//	@OneToOne
	// @JoinColumn(name ="VEHICLE_ID" )
	// private Vehicle vehicle;

	/*
	 * @OneToMany
	 * 
	 * @JoinTable(name = "USER_VEHICLE", joinColumns = @JoinColumn(name =
	 * "USERrr_ID"), inverseJoinColumns = @JoinColumn(name = "VEHICLEee_ID"))
	 * private Collection<Vehicle> vehcleList = new ArrayList();
	 */

	/*
	 * @OneToMany(mappedBy = "userdetails") private Collection<Vehicle> vehcleList =
	 * new ArrayList();
	 */
	@ManyToMany(mappedBy = "userdetails",cascade = CascadeType.PERSIST)
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
