package WheeledTransportation;

public class WheeledTransportation {
	private int nbOfWheels;
	private double maxSpeed;
	private static long serialNb = 1;
	private static int nbCreated;
// default constructor	
	public WheeledTransportation() {
		nbOfWheels = 0;
		maxSpeed = 0;
		serialNb = 1;
		nbCreated++;
	}
// parameterized constructor	
	public WheeledTransportation(int inNbOfWheels, double inMaxSpeed) {
		nbOfWheels = inNbOfWheels;
		maxSpeed = inMaxSpeed;
		serialNb = 1;
		nbCreated++;
	}
// copy constructor
	public WheeledTransportation(WheeledTransportation anotherWheeledTransportation) {
		this.nbOfWheels = anotherWheeledTransportation.nbOfWheels;
		this.maxSpeed = anotherWheeledTransportation.maxSpeed;
		serialNb = getNextSerialNumber();
		nbCreated++;
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
	public int getNbCreated() {
		return nbCreated;
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
	public void setNbCreated(int inNbCreated) {
		nbCreated = inNbCreated;
	}
// custom method	
	public long getNextSerialNumber() {
		return serialNb++;
	}
// override methods
	public String toString() {
		return "This " + this.getClass().getSimpleName() + " - serial #" + getNextSerialNumber() + " - has " + nbOfWheels + ", has a maximum speed of " + maxSpeed + " km/hr. It has " + nbCreated + " vehicles";
	}
	
	
}