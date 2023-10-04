package ProgramClasses;

public class SpecialProgram extends Program {
	private int duration;
	private static int creditCost;
// constructors
	public SpecialProgram() {
		super();
		this.duration = 0;
		creditCost = 0;
	}
	public SpecialProgram(String inName, String inSpecialization, String inInstitution, String[] inRequiredCourses, String[] inElectiveCourses, int inTotalCredits, int inDuration, int inCreditCost) {
		super(inName, inSpecialization, inInstitution, inRequiredCourses, inElectiveCourses, inTotalCredits) ;
		this.duration = inDuration;
		creditCost = inCreditCost;
	}
	public SpecialProgram(SpecialProgram otherSpecialProgram) {
		super(otherSpecialProgram);
		this.duration = otherSpecialProgram.duration;
		creditCost = otherSpecialProgram.creditCost;
	}
// accessor methods
	public int getDuration() {
		return duration;
	}
	public int getCreditCost() {
		return creditCost;
	}
// setters methods
	public void setDuration(int inDuration) {
		duration = inDuration;
	}
	public void setCreditCost(int inCreditCost) {
		creditCost = inCreditCost;
	}
	// override methods
	public String toString() {
        return super.toString() + ", and the duration of this program is: " + duration;
    }

	public boolean equals(SpecialProgram otherSpecialProgram) {
        if (this == otherSpecialProgram) {
            return true;
        }
        if (otherSpecialProgram == null || getClass() != otherSpecialProgram.getClass()) {
            return false;
        }
        if (!super.equals(otherSpecialProgram)) {
            return false;
        }
        return duration ==(otherSpecialProgram.duration);
    }
}