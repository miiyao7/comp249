// importing all the other classes needed
import ProgramClasses.Program;
import ProgramClasses.GraduateProgram;
import ProgramClasses.UndergraduateProgram;
import ProgramClasses.CertificateProgram;
import ProgramClasses.SpecialProgram;
import RemainingClasses.Course;

public class driver {

// creating the findLeastAndMostExpensiveProgram method
	 public static void findLeastAndMostExpensiveProgram(Object[] objects) {
	        Program leastExpensive = null;
	        Program mostExpensive = null;

	        for (Object obj : objects) {
	            if (obj instanceof Program) {
	                Program program = (Program) obj;
	                if (leastExpensive == null || program.getTotalCredits() < leastExpensive.getTotalCredits()) {
	                    leastExpensive = program;
	                }
	                if (mostExpensive == null || program.getTotalCredits() > mostExpensive.getTotalCredits()) {
	                    mostExpensive = program;
	                }
	            }
	        }
	       
	        if (leastExpensive != null && mostExpensive != null) {
	            System.out.println("The least Expensive Program is : " + leastExpensive);
	            System.out.println("The most Expensive Program is : " + mostExpensive);
	        } else if (leastExpensive != null && mostExpensive == null) {
	            System.out.println("There is only one Program object found, thus it is the least and most expensive:");
	            System.out.println(leastExpensive);
	        } else {
	            System.out.println("There is no Program objects found in the array.");
	        }
	    }

// main declaration
	public static void main(String[] args) {
		
// creating objects of different classes
		Program p1 = new Program("Chemistry", "Organic", "ConU", null, null, 70);
		Program p2 = new Program("Chemistry", "Solutions", "ConU", null, null, 50);
		Program p3 = new Program("Chemistry", "General", "ConU", null, null, 30);
		Program p4 = new Program("Physics", "Mechanics", "ConU", null, null, 60);
		Program p5 = new Program("Physics", "E&M", "ConU", null, null, 100);
		Program p6 = new Program("Physics", "W&M", "ConU", null, null, 80);
		Program p7 = new Program("Biology", "General", "ConU", null, null, 30);

		
		GraduateProgram gp1 = new GraduateProgram("Psychology", "Cognitive Science", "ConU", null, null, 180, "MeowMeow", 700);
		GraduateProgram gp2 = new GraduateProgram("Psychology", "NeuroScience", "ConU", null, null, 180, "MeowMeow", 700);
		
		
		UndergraduateProgram up1 = new UndergraduateProgram("Computer Science", "General", "ConU", null, null, 150, true, 500);
		UndergraduateProgram up2 = new UndergraduateProgram("Math and Computer Science", "General", "ConU", null, null, 150, true, 500);
	
		SpecialProgram sp1 = new SpecialProgram("Nursing", "General", "ConU", null, null, 150, 180, 1000);
		SpecialProgram sp2 = new SpecialProgram("Special Care", "General", "ConU", null, null, 150, 180, 1000);
		
		CertificateProgram cp1 = new CertificateProgram("Law Management", "General", "ConU", null, null, 150, 50, 1500);
		CertificateProgram cp2 = new CertificateProgram("Data Management", "General", "ConU", null, null, 150, 50, 1500);
	
		Course c1 = new Course("Dance", 20);
		Course c2 = new Course("Theater", 20);
		Course c3 = new Course("Art", 20);
		Course c4 = new Course("Phys Ed", 20);
		Course c5 = new Course("Spanish", 20);
		Course c6 = new Course("Vietnamese", 20);
		Course c7 = new Course("French", 20);
		Course c8 = new Course("Latin", 20);
		Course c9 = new Course("Korean", 20);
		Course c10 = new Course("English", 20);
		Course c11 = new Course("Japanese", 20);
		Course c12 = new Course("Mandarin", 20);
		Course c13 = new Course("Cantonese", 20);
		Course c14 = new Course("Tagalog", 20);
		Course c15 = new Course("Russian", 20);
		
// printing out the objects created using the toString() method
				System.out.println("Printing out 10 different objects from mixed classes...");
			System.out.println(p1);
	        System.out.println(p2);
	        System.out.println(p3);
	        System.out.println(p4);
	        System.out.println(p5);
	        System.out.println(gp1);
	        System.out.println(up1);
	        System.out.println(up2);
	        System.out.println(cp1);
	        System.out.println(sp1);
	        
// Testing the equality of some objects using the equals() method and printing them out
	        System.out.println("\nTesting the equality of some objects using the equals() method and printing them out...");
	     System.out.println(p1.equals(p2));
	     System.out.println(p1.equals(p1));
	     System.out.println(up1.equals(up2));
	     System.out.println(cp1.equals(sp1));
	     System.out.println(p4.equals(p5));
	     
// creating two arrays, each with 15 to 20 mixed objects from the classes
	     Object[] programs = {p1, p2, p3, p4, p5, p6, p7, gp1, gp2, up1, up2, sp1, sp2, cp1, cp2};
	     Object[] courses = {c1, c2, c3, c4, c5, c6, c7, c8, c9, c10, c11, c12, c13, c14, c15};

// calling the findLeastAndMostExpensiveProgram() method on the 2 arrays
	     System.out.println("\nFinding the most and least expensive program of the array programs...   ");
	     findLeastAndMostExpensiveProgram(programs);
	     System.out.println("\nFinding the most and least expensive program of the array courses...   ");
	     findLeastAndMostExpensiveProgram(courses);
	     
	}
	
}
