package TrainAndTram;
import WheeledTransportation.WheeledTransportation;

public class Train extends WheeledTransportation {
// variable declaration
	private int nbOfV;
	private String startingStation;
	private String destStationName;
	private static long serialNb;

	public Train() {
		super();
		this.nbOfV = 0;
		this.startingStation = "";
		this.destStationName = "";
		serialNb = 1000;
	}
	
	public Train(int inNbOfWheels, double inMaxSpeed, int inNbOfV, String inStartingStation, String inDestStationName) {
		super(inNbOfWheels, inMaxSpeed);
		this.nbOfV = inNbOfV;
		this.startingStation = inStartingStation;
		this.destStationName = inDestStationName;
		serialNb = 1000;
	}
	
	public Train(Train otherTrain) {
		super(otherTrain);
		this.nbOfV = otherTrain.nbOfV;
		this.startingStation = otherTrain.startingStation;
		this.destStationName = otherTrain.destStationName;
		serialNb = getNextSerialNumber();
	}
	
	// getters method
		public String getStartingStation() {
			return startingStation;
		}
		public String getDestStationName() {
			return destStationName;
		}
		public long getSerialNb() {
			return serialNb;
		}
	// setter method
		public void setStartingStation(String inStartingStation) {
			startingStation = inStartingStation;
		}
		public void setDestStationName(String inDestStationName) {
			destStationName = inDestStationName;
		}
		public void setSerialNb(int inSerialNb) {
			serialNb = inSerialNb;
		}

//	@override
	public long getNextSerialNumber() {
		return serialNb++;
	}
	
	public String toString() {
		return super.toString() + " and its starting destination are " + startingStation + " and " + destStationName;
				}
	public boolean equals(Train object) {
		if(object == null || getClass() != object.getClass()) {
			return false;
		}
		else if (!super.equals(object)) {
			return false;
		}
		if(this.nbOfV == object.nbOfV && this.startingStation == object.startingStation && this.destStationName == object.destStationName) {
			return true;
		}
		else
			return false;
	}
	
}
