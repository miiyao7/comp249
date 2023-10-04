package WheeledTransportation;

public class WheeledTransportation {
	private int nbOfWheels;
	private double maxSpeed;
	private long serialNb;
// default constructor	
	public WheeledTransportation() {
		nbOfWheels = 0;
		maxSpeed = 0;
		serialNb = getNextSerialNumber();
	}
// parameterized constructor	
	public WheeledTransportation(int inNbOfWheels, double inMaxSpeed) {
		nbOfWheels = inNbOfWheels;
		maxSpeed = inMaxSpeed;
		serialNb = getNextSerialNumber();
	}
// copy constructor
	public WheeledTransportation(WheeledTransportation anotherWheeledTransportation) {
		this.nbOfWheels = anotherWheeledTransportation.nbOfWheels;
		this.maxSpeed = anotherWheeledTransportation.maxSpeed;
		serialNb = getNextSerialNumber();
	}
// getters method
	public int getNbOfWheels() {
		return nbOfWheels;
	}
	public double getMaxSpeed() {
		return maxSpeed;
	}
	public long getSerialNb() {
		return serialNb;
	}

// setter method
	public void setNbOfWheels(int inNbOfWheels) {
		nbOfWheels = inNbOfWheels;
	}
	public void setMaxSpeed(double inMaxSpeed) {
		maxSpeed = inMaxSpeed;
	}
	public void setSerialNb(int inSerialNb) {
		serialNb = inSerialNb;
	}

	
	private static long nextSerialNb=1;
	
// custom method	
	public long getNextSerialNumber() {
		return nextSerialNb++;
	}
// override methods
	public String toString() {
		return "This " + this.getClass().getSimpleName() + " - serial #" + getNextSerialNumber() + " - has " + nbOfWheels + " wheels, has a maximum speed of " + maxSpeed + " km/hr.";
	}
	public boolean equals(WheeledTransportation object) {
		if(object == null || getClass() != object.getClass()) {
			return false;
		}
		else if (this.maxSpeed == object.maxSpeed && this.nbOfWheels == object.nbOfWheels) {
			return true;
		}
		else 
			return false;	 
	}
	
}
