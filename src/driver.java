import WheeledTransportation.WheeledTransportation;
import TrainAndTram.Train;
import Metro.Metro;
import Aircraft.Aircraft;
import Aircraft.WW2Aircraft;
import Monowheel.Monowheel;
import TrainAndTram.Tram;
import Ferry.Ferry;

public class driver {

// custom method to find the least and most expensive aircraft through an array
	public static void findLeastAndMostExpensiveAircraft(Object[] mixedObjects) {
		  Aircraft leastExpensive = null;
	        Aircraft mostExpensive = null;
	        // iterating over the array to verify if the object in the array is an aircraft object
	        for (Object obj : mixedObjects) {
	            if (obj instanceof Aircraft) {
	                Aircraft aircraft = (Aircraft) obj;
	                // finding out which object is the least expensive
	                if (leastExpensive == null || aircraft.getPrice() < leastExpensive.getPrice()) {
	                    leastExpensive = aircraft;
	                }
	             // finding out which object is the most expensive
	                if (mostExpensive == null || aircraft.getPrice() > aircraft.getPrice()) {
	                    mostExpensive = aircraft;
	                }
	            }
	        }
	       // printing out the least and most expensive
	        if (leastExpensive != null && mostExpensive != null) {
	            System.out.println("The least Expensive Aircraft is : " + leastExpensive);
	            System.out.println("The most Expensive Aircraft is : " + mostExpensive);
	        // if the most expensive is null then only one Aircraft is found thus it is both the least and more expensive one
	        } else if (leastExpensive != null && mostExpensive == null) {
	            System.out.println("There is only one Aircraft found, thus it is the least and most expensive:");
	            System.out.println(leastExpensive);
	        // if no aircraft object has been found in the array
	        } else {
	            System.out.println("There is no Aircraft found in the array.");
	        }
	}
	
	// main 
	public static void main(String[] args) {
// creating 19 objects 
	Train t1 = new Train(12, 4, 3, "mtl", "hn");
	Train t2 = new Train(11, 4, 3, "mtl", "hn");
	Metro m1 = new Metro();
	Metro m2 = new Metro();
	Metro m3 = new Metro();
	WheeledTransportation wt1 = new WheeledTransportation(12, 4);
	WheeledTransportation wt2 = new WheeledTransportation(12, 4);
	Aircraft a1 = new Aircraft(3, 4);
	Aircraft a2 = new Aircraft(1, 2);
	Tram tr1 = new Tram();
	Tram tr2 = new Tram();
	Tram tr3 = new Tram();
	Monowheel mo1 = new Monowheel();
	Monowheel mo2 = new Monowheel();
	Monowheel mo3 = new Monowheel();
	WW2Aircraft wa1 = new WW2Aircraft(58, 9, true);
	WW2Aircraft wa2 = new WW2Aircraft(58, 9, true);
	Ferry f1 = new Ferry(2, 3);
	Ferry f2 = new Ferry(1, 2);
	Ferry f3 = new Ferry(2, 4);

	// creating array of mixed objects including aircraft objects
	Object[] array = {t1, t2, m1, m2, wt1, wt2, a1, a2, tr1, tr2, mo1, mo2, wa1, wa2, f1, f2} ;
	// creating array of mixed objects not including aircraft objects
	Object[] array2 = {t1, t2, m1, m2, wt1, wt2, m3, tr3, tr1, tr2, mo1, mo2, f3, mo3, f1, f2} ;
	
	// printing out the infos of 16 objects
	System.out.println("\nDisplaying all infos of the 16 objects...");
	for (Object object: array) {
		System.out.println(object.toString());
	}
	
	// testing the equality 
	System.out.println("\nChecking 2 objects from different classes...");
	System.out.println("Checking if m1 is equal to tr1...");
	System.out.println(m1.equals(tr1));
	System.out.println("Checking if mo1 is equal to m2...");
	System.out.println(mo1.equals(m2));
//
	System.out.println("\nChecking 2 objects from the same class with different values...");
	System.out.println("Checking if t1 is equal to t2...");
	System.out.println(t1.equals(t2));
	System.out.println("Checking if f1 is equal to f2...");
	System.out.println(f1.equals(f2));
//
	System.out.println("\nChecking 2 objects from the same class with similar values...");
	System.out.println("Checking if wt1 is equal to wt2...");
	System.out.println(wt1.equals(wt2));
	System.out.println("Checking if wa1 is equal to wa2...");
	System.out.println(wa1.equals(wa2)+"\n");

// calling the findLeastAndMostExpensiveAircraft() with the 2 arrays
	System.out.println("Calling the findLeastAndMostExpensiveAircraft() method on the first array with mixed objects including Aircraft objects...");
	findLeastAndMostExpensiveAircraft(array);
	System.out.println("\nCalling the findLeastAndMostExpensiveAircraft() method on the second array with mixed objects not including Aircraft objects...");
	findLeastAndMostExpensiveAircraft(array2);
	}
}
