package WheeledTransportation;

public class WheeledTransportation {
	private int nbOfWheels;
	private double maxSpeed;
	private static long serialNb = 1;
// default constructor	
	public WheeledTransportation() {
		nbOfWheels = 0;
		maxSpeed = 0;
		serialNb = 1;
	}
// parameterized constructor	
	public WheeledTransportation(int inNbOfWheels, double inMaxSpeed) {
		nbOfWheels = inNbOfWheels;
		maxSpeed = inMaxSpeed;
		serialNb = 1;
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

// custom method	
	public long getNextSerialNumber() {
		return serialNb++;
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
