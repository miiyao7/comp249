package ProgramClasses;

public class Program {

	private String name, specialization, institution;
	private String[] requiredCourses, electiveCourses;
	private int totalCredits;

// constructors
	public Program() {
		name = "";
		specialization = "";
		institution = "";
		requiredCourses = new String[0];
		electiveCourses = new String[0];
		totalCredits =  0;
	}
	public Program(String inName, String inSpecialization, String inInstitution, String[] inRequiredCourses, String[] inElectiveCourses, int inTotalCredits) {
		name = inName;
		specialization = inSpecialization;
		institution = inInstitution;
		requiredCourses = inRequiredCourses;
		electiveCourses = inElectiveCourses;
		totalCredits = inTotalCredits;
	}
	public Program(Program otherProgram) {
		this.name = otherProgram.name;
		this.specialization = otherProgram.specialization;
		this.institution = otherProgram.institution;
		this.requiredCourses = otherProgram.requiredCourses;
		this.electiveCourses = otherProgram.electiveCourses;
		this.totalCredits = otherProgram.totalCredits;
	}
// accessors methods
	public String getName() {  
		return name;
	}
	public String getSpecialization() {  
		return specialization;
	}
	public String getInstitution() {  
		return institution;
	}
	public String[] getRequiredCourses() {  
		return requiredCourses;
	}
	public String[] getElectiveCourses() {  
		return electiveCourses;
	}
	public int getTotalCredits() {  
		return totalCredits;
	}
// setters methods
	public void setName(String inName) {
		name = inName;
	}
	public void setSpecialization(String inSpecialization) {
		specialization = inSpecialization;
	}
	public void setInstitution(String inInstitution) {
		institution = inInstitution;
	}
	public void setRequiredCourses(String[] inRequiredCourses) {
		requiredCourses = inRequiredCourses;
	}
	public void setElectiveCourses(String[] inElectiveCourses) {
		electiveCourses = inElectiveCourses;
	}
	public void setTotalCredits(int inTotalCredits) {
		totalCredits = inTotalCredits;
	}
	
// override methods
	public String toString() {
		return("The class is " + name + ", the specialization is " + specialization + ", the institution is " + institution + ", the total credits are " + totalCredits ); 
	}
	public boolean equals(Program otherProgram) {
		if (this == otherProgram) {
			return true;
		} 
		if(otherProgram == null || getClass() != otherProgram.getClass()) {
			return false;
		}
		else
			return false;
	}
}






