package Aircraft;

public class WW2Aircraft extends Aircraft {
	private boolean twinEngine;
	private long serialNb;
	
	public WW2Aircraft() {
		super();
		twinEngine = false;
	}
	
	public WW2Aircraft(double inPrice, double inMaxElevation, boolean inTwinEngine) {
		super(inPrice, inMaxElevation);
		this.twinEngine = inTwinEngine;
	}
	
	public WW2Aircraft(WW2Aircraft otherWW2Aircraft) {
		super(otherWW2Aircraft);
		this.twinEngine = otherWW2Aircraft.twinEngine;
		serialNb = getNextSerialNumber();
	}
	
	// getters method
		public boolean getTwinEngine() {
			return twinEngine;
		}
		public long getSerialNb() {
			return serialNb;
		}
	// setter method
		public void setTwinEngine(boolean inTwinEngine) {
			twinEngine = inTwinEngine;
		}
		public void setSerialNb(int inSerialNb) {
			serialNb = inSerialNb;
		}
private static long nextSerialNb = 80000;
	
//	@override
	public long getNextSerialNumber() {
		return nextSerialNb++;
	}
	public String toString() {
		return super.toString();
				}
	public boolean equals(WW2Aircraft object) {
		if(object == null || getClass() != object.getClass()) {
			return false;
		}
		else if (!super.equals(object)) {
			return false;
		}
		if(this.twinEngine == object.twinEngine ) {
			return true;
		}
		else
			return false;
	}
}
