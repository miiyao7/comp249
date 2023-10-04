import WheeledTransportation.WheeledTransportation;
import TrainAndTram.Train;
import Metro.Metro;


public class driver {
	public static void main(String[] args) {
	Train t1 = new Train(12, 4, 3, "mtl", "hn");
	Train t2 = new Train(11, 4, 3, "mtl", "hn");
	Metro m1 = new Metro();
	Metro m2 = new Metro();
	WheeledTransportation wt1 = new WheeledTransportation(12, 4);
	WheeledTransportation wt2 = new WheeledTransportation(12, 4);
	
	
	Object[] array = {t1, t2, m1, m2, wt1, wt2} ;
	
	for (Object object: array) {
		System.out.println(object.toString());
	}
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
	
	}
}
