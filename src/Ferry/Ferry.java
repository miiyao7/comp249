package Ferry;

public class Ferry {
	private double maxSpeed;
	private double maxLoad;
	private long serialNb;
	
	public Ferry() {
		maxSpeed = 0;
		maxLoad = 0;
		serialNb = getNextSerialNumber();
	}
	
	public Ferry(double inMaxSpeed, double inMaxLoad) {
		this.maxSpeed = inMaxSpeed;
		this.maxLoad = inMaxLoad;
		serialNb = getNextSerialNumber();
	}
	
	public Ferry(Ferry otherFerry) {
		this.maxSpeed = otherFerry.maxSpeed;
		this.maxLoad = otherFerry.maxLoad;
		serialNb = getNextSerialNumber();
	}
	
// getters method
	public double getMaxSpeed() {
		return maxSpeed;
	}
	public double getMaxLoad() {
		return maxLoad;
	}
	public long getSerialNb() {
		return serialNb;
	}
// setter method
	public void setMaxSpeed(double inMaxSpeed) {
		maxSpeed = inMaxSpeed;
	}
	public void setMaxLoad(double inMaxLoad) {
		maxLoad = inMaxLoad;
	}
	public void setSerialNb(int inSerialNb) {
		serialNb = inSerialNb;
	}

	private static long nextSerialNb = 70000;
	
//	@override
	public long getNextSerialNumber() {
		return nextSerialNb++;
	}
	public String toString() {
		return "This " + this.getClass().getSimpleName() + " - serial #" + serialNb + " - has a maximum speed of " + maxSpeed + " km/hr, has a maximum load of " + maxLoad + " kg.";
				}
	public boolean equals(Ferry object) {
		if(object == null || getClass() != object.getClass()) {
			return false;
		}
		else if (this.maxSpeed == object.maxSpeed && this.maxLoad == object.maxLoad) {
			return true;
		}
		else 
			return false;	 
	}
}
