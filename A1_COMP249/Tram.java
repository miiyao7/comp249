package TrainAndTram;
import Metro.Metro;

public class Tram extends Metro{
private int yearCreation;
private static long serialNb;


	public Tram() {
		super();
		yearCreation = 0;
		serialNb = 30000;
	}
	public Tram(int inNbOfWheels, double inMaxSpeed, int inNbOfV, String inStartingStation, String inDestStationName, int inNbOfStops, int inYearCreation) {
		super(inNbOfWheels, inMaxSpeed, inNbOfV, inStartingStation, inDestStationName, inNbOfStops);
		this.yearCreation = inYearCreation;
		serialNb = 30000;
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
	
//	@override
	public long getNextSerialNumber() {
		return serialNb++;
	}
	public String toString() {
		return super.toString();
				}
}
