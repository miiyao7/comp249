import WheeledTransportation.WheeledTransportation;
import TrainAndTram.Train;
import TrainAndTram.Tram;
import Metro.Metro;


public class driver {
	public static void main(String[] args) {
	Train t1 = new Train();
	Train t2 = new Train();
	Metro m1 = new Metro();
	Metro m2 = new Metro();
	Tram tr1 = new Tram();
	System.out.println(t1.toString());
	System.out.println(t2.toString());
	System.out.println(m1.toString());
	System.out.println(m2.toString());
	System.out.println(tr1.toString());
	}
}
