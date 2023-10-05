package TrainAndTram;
import WheeledTransportation.WheeledTransportation;

public class Train extends WheeledTransportation {
// variable declaration
	private int nbOfV;
	private String startingStation;
	private String destStationName;
	private long serialNb;

	public Train() {
		super();
		this.nbOfV = 0;
		this.startingStation = "mtl";
		this.destStationName = "hn";
	}
	
	public Train(int inNbOfWheels, double inMaxSpeed, int inNbOfV, String inStartingStation, String inDestStationName) {
		super(inNbOfWheels, inMaxSpeed);
		this.nbOfV = inNbOfV;
		this.startingStation = inStartingStation;
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

		private static long nextSerialNb=1000;
		
//	@override
	public long getNextSerialNumber() {
		return nextSerialNb++;
	}
	
	public String toString() {
		return super.toString() + " It has " + nbOfV + " vehicles and its starting and destination stations are " + startingStation + " and " + destStationName ;
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
