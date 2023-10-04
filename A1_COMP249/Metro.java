package Metro;
import TrainAndTram.Train;
public class Metro extends Train{
	private int nbOfStops;
	private long serialNb;
	
	public Metro() {
		super();
		nbOfStops = 0;
	}
	
	public Metro(int inNbOfWheels, double inMaxSpeed, int inNbOfV, String inStartingStation, String inDestStationName, int inNbOfStops) {
		super(inNbOfWheels, inMaxSpeed, inNbOfV, inStartingStation, inDestStationName);
		nbOfStops = inNbOfStops;
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
	
	private static long nextSerialNb=25000;
	
//	@override
	public long getNextSerialNumber() {
		return nextSerialNb++;
	}
	public String toString() {
		return super.toString();
				}
}
