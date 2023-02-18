package my.training.stockpricereaderservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

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
	
	@ManyToOne
	@JoinColumn(name = "user_id")
	@NotFound(action = NotFoundAction.IGNORE)
	private Userdetails userdetails;

	public int getVehicleId() {
		return vehicleId;
	}

	
	


	public Userdetails getUserdetails() {
		return userdetails;
	}





	public String getVehicleName() {
		return vehicleName;
	}





	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}





	public void setUserdetails(Userdetails userdetails) {
		this.userdetails = userdetails;
	}


	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

}
