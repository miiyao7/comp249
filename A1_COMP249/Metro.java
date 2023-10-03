package Metro;
import TrainAndTram.Train;
public class Metro extends Train{
	private int nbOfStops;
	private static long serialNb;
	
	public Metro() {
		super();
		nbOfStops = 0;
		serialNb = 25000;
	}
	
	public Metro(int inNbOfWheels, double inMaxSpeed, int inNbOfV, String inStartingStation, String inDestStationName, int inNbOfStops) {
		super(inNbOfWheels, inMaxSpeed, inNbOfV, inStartingStation, inDestStationName);
		nbOfStops = inNbOfStops;
		serialNb= 25000;
	}
	public Metro(Metro otherMetro) {
		super(otherMetro);
		this.nbOfStops = otherMetro.nbOfStops;
		serialNb = getNextSerialNumber();
	}
	
	// getters method
	public double getNbOfStops() {
		return nbOfStops;
	}
	public long getSerialNb() {
		return serialNb;
	}
// setter method
	public void setNbOfStops(int inNbOfStops) {
		nbOfStops = inNbOfStops;
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

