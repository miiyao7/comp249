import WheeledTransportation.WheeledTransportation;
import TrainAndTram.Train;
import Metro.Metro;
import Aircraft.Aircraft;

public class driver {
	
	public static void findLeastAndMostExpensiveAircraft(Object[] mixedObjects) {
		  Aircraft leastExpensive = null;
	        Aircraft mostExpensive = null;

	        for (Object obj : mixedObjects) {
	            if (obj instanceof Aircraft) {
	                Aircraft aircraft = (Aircraft) obj;
	                if (leastExpensive == null || aircraft.getPrice() < leastExpensive.getPrice()) {
	                    leastExpensive = aircraft;
	                }
	                if (mostExpensive == null || aircraft.getPrice() > aircraft.getPrice()) {
	                    mostExpensive = aircraft;
	                }
	            }
	        }
	       
	        if (leastExpensive != null && mostExpensive != null) {
	            System.out.println("The least Expensive Aircraft is : " + leastExpensive);
	            System.out.println("The most Expensive Aircraft is : " + mostExpensive);
	        } else if (leastExpensive != null && mostExpensive == null) {
	            System.out.println("There is only one Aircraft found, thus it is the least and most expensive:");
	            System.out.println(leastExpensive);
	        } else {
	            System.out.println("There is no Aircraft found in the array.");
	        }
	}
	
	
	
	public static void main(String[] args) {
	Train t1 = new Train(12, 4, 3, "mtl", "hn");
	Train t2 = new Train(11, 4, 3, "mtl", "hn");
	Metro m1 = new Metro();
	Metro m2 = new Metro();
	WheeledTransportation wt1 = new WheeledTransportation(12, 4);
	WheeledTransportation wt2 = new WheeledTransportation(12, 4);
	Aircraft a1 = new Aircraft(3, 4);
	Aircraft a2 = new Aircraft(1, 2);
	
	
	Object[] array = {t1, t2, m1, m2, wt1, wt2, a1, a2} ;
	
	for (Object object: array) {
		System.out.println(object.toString());
	}
	
	System.out.println(a1.getSerialNb());
	System.out.println(a2.getSerialNb());
/*
	System.out.println(t1.toString());
	System.out.println(t2.toString());
	System.out.println(m1.toString());
	System.out.println(m2.toString());
	System.out.println(wt1.toString());
	System.out.println(wt2.toString()+"\n");
	*/
	System.out.println("\nChecking if wt1 is equal to wt2...");
	System.out.println(wt1.equals(wt2));
	System.out.println("Checking if t1 is equal to t2...");
	System.out.println(t1.equals(t2));
	
	findLeastAndMostExpensiveAircraft(array);
	
	}
}
