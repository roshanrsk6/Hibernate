package my.training.stockpricereaderservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Vehicle {

	@Id
	@GeneratedValue
	private int vehicleId;

	@Column(name = "VEHICLE_NAME")
	private String vehicleName;

	

	public int getVehicleId() {
		return vehicleId;
	}


	public String getVehicleName() {
		return vehicleName;
	}





	public void setVehicleId(int vehicleId) {
		this.vehicleId = vehicleId;
	}





	public void setVehicleName(String vehicleName) {
		this.vehicleName = vehicleName;
	}

}
