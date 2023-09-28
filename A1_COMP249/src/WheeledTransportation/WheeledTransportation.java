package WheeledTransportation;

public class WheeledTransportation {
	private int nbOfWheels;
	private double maxSpeed;
	private long serialNumber;
	int nbCreated;
// default constructor	
	public WheeledTransportation() {
		nbOfWheels = 0;
		maxSpeed = 0;
		serialNumber = 0;
		nbCreated++;
	}
// parameterized constructor	
	public WheeledTransportation(int inNbOfWheels, double inMaxSpeed, long inSerialNumber) {
		nbOfWheels = nbOfWheels;
		maxSpeed = maxSpeed;
		serialNumber = inSerialNumber;
		nbCreated++;
	}
// copy constructor
	public WheeledTransportation(WheeledTransportation anotherWheeledTransportation) {
		this.nbOfWheels = anotherWheeledTransportation.nbOfWheels;
		this.maxSpeed = anotherWheeledTransportation.maxSpeed;
		this.serialNumber = anotherWheeledTransportation.serialNumber;
		nbCreated++;
	}
// custom method	
	public long getNextSerialNumber() {
		return serialNumber++;
	}
// override methods
	public String toString() {
		return "This wheeled transportation - serial #" + serialNumber + " - has " + nbOfWheels + ", has a maximum speed of " + maxSpeed + " km/hr. It has " + nbCreated + "vehicles and its starting and destinations stations are Montreal and Toronto";
	}
	
	
}
