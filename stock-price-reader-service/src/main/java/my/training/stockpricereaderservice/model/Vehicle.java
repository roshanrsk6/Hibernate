package my.training.stockpricereaderservice.model;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue
	private int vehicleId;

	@Column(name = "VEHICLE_NAME")
	private String vehicleName;

	/*
	 * @ManyToOne
	 * 
	 * @JoinTable(name = "USER_VEHICLE", joinColumns = @JoinColumn(name =
	 * "VEHICLEee_ID"), inverseJoinColumns = @JoinColumn(name = "USERrr_ID"))
	 * private Userdetails userdetails;
	 */
	
	@ManyToMany(mappedBy = "vehcleList")
	private Collection<Userdetails> userlist = new ArrayList();

	public int getVehicleId() {
		return vehicleId;
	}

	
	public Collection<Userdetails> getUserlist() {
		return userlist;
	}


	public void setUserlist(Collection<Userdetails> userlist) {
		this.userlist = userlist;
	}


	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}

	public String getVehicleName() {
		return vehicleName;
	}

	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

}
