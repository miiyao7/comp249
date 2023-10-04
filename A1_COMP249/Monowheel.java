package Monowheel;
import WheeledTransportation.WheeledTransportation;

public class Monowheel extends WheeledTransportation{
	private double maxWeight;
	private static long serialNb;
	
	public Monowheel() {
		super();
		maxWeight = 0;
		serialNb = 55000;
	}
	public Monowheel(int inNbOfWheels, double inMaxSpeed, double inMaxWeight) {
		super(inNbOfWheels,inMaxSpeed);
		this.maxWeight = inMaxWeight;
		serialNb = 55000;
	}
	public Monowheel(Monowheel otherMonowheel) {
		super(otherMonowheel);
		this.maxWeight = otherMonowheel.maxWeight;
		serialNb = getNextSerialNumber();
	}
	
	// getters method
		public double getMaxWeight() {
			return maxWeight;
		}
		public long getSerialNb() {
			return serialNb;
		}
	// setter method
		public void setMaxWeight(double inMaxWeight) {
			maxWeight = inMaxWeight;
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
	public boolean equals(Tram object) {
		if(object == null || getClass() != object.getClass()) {
			return false;
		}
		else if (!super.equals(object)) {
			return false;
		}
		if(this.maxWeight == object.maxWeight ) {
			return true;
		}
		else
			return false;
	}
	
}
