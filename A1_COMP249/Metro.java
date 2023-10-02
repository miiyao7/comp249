package Metro;
import TrainAndTram.Train;
public class Metro extends Train{
	int nbOfStops;
	private static long serialNb=25000;
	
	public Metro() {
		super();
		nbOfStops = 0;
		serialNb = getNextSerialNumber();
	}
	
	public Metro(int inNbOfWheels, double inMaxSpeed, int inNbOfV, String inStartingStation, String inDestStationName, int inNbOfStops, long inSerialNb) {
		super(inNbOfWheels, inMaxSpeed, inNbOfV, inStartingStation, inDestStationName, 0);
		nbOfStops = inNbOfStops;
		serialNb= getNextSerialNumber();
	}
	public Metro(Metro otherMetro) {
		super(otherMetro);
		this.nbOfStops = otherMetro.nbOfStops;
		this.serialNb = getNextSerialNumber();
	}
	
	public static long getNextSerialNumber() {
		serialNb = 2500;
		return serialNb;
	}
	public String toString() {
		return super.toString() + serialNb + trial();
				}
}


