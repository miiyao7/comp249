package Aircraft;

public class Aircraft {
private double price;
private double maxElevation;
private long serialNb;

	public Aircraft() {
		price = 0;
		maxElevation = 0;
		serialNb = getNextSerialNumber();
	}
	
	public Aircraft(double inPrice, double inMaxElevation) {
		this.price = inPrice;
		this.maxElevation = inMaxElevation;
		serialNb = getNextSerialNumber();
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
		
		
	private static long nextSerialNb=1;
		
//	@override
	public long getNextSerialNumber() {
		return nextSerialNb++;
	}
	
	
	public String toString() {
		return "This " + this.getClass().getSimpleName() + " - serial #" + serialNb + " - is $" + price + ", has a maximum elevation of " + maxElevation + ".";
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
