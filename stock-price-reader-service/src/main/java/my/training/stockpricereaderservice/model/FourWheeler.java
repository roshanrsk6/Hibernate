package my.training.stockpricereaderservice.model;

import javax.persistence.Entity;

@Entity
public class FourWheeler  extends Vehicle{

	private String steeringwheel;

	public String getSteeringwheel() {
		return steeringwheel;
	}

	public void setSteeringwheel(String steeringwheel) {
		this.steeringwheel = steeringwheel;
	}
	
	
}
