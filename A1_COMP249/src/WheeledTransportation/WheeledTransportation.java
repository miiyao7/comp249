package WheeledTransportation;


public class WheeledTransportation {
	private int nbOfWheels;
	private double maxSpeed;
	private static long serialNb = 1;
	int nbCreated;
// default constructor	
	public WheeledTransportation() {
		nbOfWheels = 0;
		maxSpeed = 0;
		serialNb = getNextSerialNumber();
		nbCreated++;
	}
// parameterized constructor	
	public WheeledTransportation(int inNbOfWheels, double inMaxSpeed, long inSerialNumber) {
		nbOfWheels = inNbOfWheels;
		maxSpeed = inMaxSpeed;
		serialNb = getNextSerialNumber();
		nbCreated++;
	}
// copy constructor
	public WheeledTransportation(WheeledTransportation anotherWheeledTransportation) {
		this.nbOfWheels = anotherWheeledTransportation.nbOfWheels;
		this.maxSpeed = anotherWheeledTransportation.maxSpeed;
		this.serialNb = getNextSerialNumber();
		nbCreated++;
	}
// custom method	
	public static long getNextSerialNumber() {
		return serialNb;
	}
// override methods
	public String toString() {
		return "This " + this.getClass().getSimpleName() + " - serial #" + serialNb + " - has " + nbOfWheels + ", has a maximum speed of " + maxSpeed + " km/hr. It has " + nbCreated + " vehicles.";
	}
	
	
}
