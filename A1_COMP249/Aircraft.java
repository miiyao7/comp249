package Aircraft;

public class Aircraft {
private double price;
private double maxElevation;
private static long serialNb;

	public Aircraft() {
		price = 0;
		maxElevation = 0;
		serialNb = 0;
	}
	
	public Aircraft(double inPrice, double inMaxElevation) {
		this.price = inPrice;
		this.maxElevation = inMaxElevation;
		serialNb = 0;
	}
	
	public Aircraft(Aircraft otherAircraft) {
		this.price = otherAircraft.price;
		this.maxElevation = otherAircraft.maxElevation;
		serialNb = getNextSerialNumber();
	}

	// getters method
		public double getPrice() {
			return price;
		}
		public double getMaxElevation() {
			return maxElevation;
		}
		public long getSerialNb() {
			return serialNb;
		}
	// setter method
		public void setPrice(double inPrice) {
			price = inPrice;
		}
		public void setMaxElevation(double inMaxElevation) {
			maxElevation = inMaxElevation;
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
	public boolean equals(Aircraft object) {
		if(object == null || getClass() != object.getClass()) {
			return false;
		}
		else if (this.maxElevation == object.maxElevation && this.price == object.price) {
			return true;
		}
		else 
			return false;	 
	}
}
