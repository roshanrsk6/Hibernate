package my.training.stockpricereaderservice.model;

import javax.persistence.Entity;

@Entity
//@DiscriminatorValue(value = "2Wheeler")
public class TwoWheeler extends Vehicle{

	
	private String steeringHandle;

	public String getSteeringHandle() {
		return steeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		this.steeringHandle = steeringHandle;
	}
	
	
}
