package Ferry;

public class Ferry {
	private double maxSpeed;
	private double maxLoad;
	private static long serialNb;
	
	public Ferry() {
		maxSpeed = 0;
		maxLoad = 0;
		serialNb = 70000;
	}
	
	public Ferry(double inMaxSpeed, double inMaxLoad) {
		this.maxSpeed = inMaxSpeed;
		this.maxLoad = inMaxLoad;
		serialNb = 70000;
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
	
	
//	@override
	public long getNextSerialNumber() {
		return serialNb++;
	}
	public String toString() {
		return super.toString();
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
