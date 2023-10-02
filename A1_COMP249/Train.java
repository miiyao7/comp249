package TrainAndTram;
import WheeledTransportation.WheeledTransportation;

public class Train extends WheeledTransportation {
// variable declaration
	private int nbOfV;
	private String startingStation;
	private String destStationName;
	private static long serialNb=1000;

	public Train() {
		super();
		nbOfV = 0;
		startingStation = "";
		serialNb = WheeledTransportation.getNextSerialNumber();
	}
	
	public Train(int inNbOfWheels, double inMaxSpeed, int inNbOfV, String inStartingStation, String inDestStationName, long inSerialNb) {
		super(inNbOfWheels, inMaxSpeed, inSerialNb);
		this.nbOfV = inNbOfV;
		this.startingStation = inStartingStation;
		this.destStationName = inDestStationName;
		this.serialNb = WheeledTransportation.getNextSerialNumber();
	}
	
	public Train(Train otherTrain) {
		super(otherTrain);
		this.nbOfV = otherTrain.nbOfV;
		this.startingStation = otherTrain.startingStation;
		this.destStationName = otherTrain.destStationName;
		this.serialNb = WheeledTransportation.getNextSerialNumber();
	}
	
	public static long getNextSerialNumber() {
		serialNb = 1000;
		return serialNb;
	}
	public String trial() {
		return "train";
	}
	
	public String toString() {
		return super.toString();
				}
	
}
