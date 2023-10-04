package TrainAndTram;
import Metro.Metro;

public class Tram extends Metro{
private int yearCreation;
private long serialNb;


	public Tram() {
		super();
		yearCreation = 0;
	}
	public Tram(int inNbOfWheels, double inMaxSpeed, int inNbOfV, String inStartingStation, String inDestStationName, int inNbOfStops, int inYearCreation) {
		super(inNbOfWheels, inMaxSpeed, inNbOfV, inStartingStation, inDestStationName, inNbOfStops);
		this.yearCreation = inYearCreation;
	}
	public Tram(Tram otherTram) {
		super(otherTram);
		this.yearCreation = otherTram.yearCreation;
		serialNb = getNextSerialNumber();
	}
	
// getters method
	public int getYearCreation() {
		return yearCreation;
	}
	public long getSerialNb() {
		return serialNb;
	}
// setter method
	public void setMaxSpeed(int inYearCreation) {
		yearCreation = inYearCreation;
	}
	public void setSerialNb(int inSerialNb) {
		serialNb = inSerialNb;
	}

private static long nextSerialNb = 30000;

//	@override
	public long getNextSerialNumber() {
		return nextSerialNb++;
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
		if(this.yearCreation == object.yearCreation ) {
			return true;
		}
		else
			return false;
	}
}
