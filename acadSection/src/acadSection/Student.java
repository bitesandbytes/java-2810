package acadSection;

public class Student extends Person 
{
	String rollNo;
	String hostel;
	double CGPA;
	int semester;
	int creditsEarned;
	int currentSemesterCreditsTotal;
	int currentSemesterCreditsEarned;
	Faculty facAd;

	public Student(String name, char sex, String nationality, String fatherName,
			String motherName, String dept, int age)
	{
		super(name, sex, nationality, fatherName, motherName, dept, age);
		rollNo = null;
		hostel = null;
		CGPA = 0;
		semester = 0;
		currentSemesterCreditsEarned = 0;
		currentSemesterCreditsTotal = 0;
		facAd = null;
	}
	
	public Student()
	{
		super();
		rollNo = null;
		hostel = null;
		CGPA = 0;
		semester = 0;
		currentSemesterCreditsEarned = 0;
		currentSemesterCreditsTotal = 0;
		facAd = null;
	}
	
	public String getRollNo()
	{
		return rollNo;
	}

	public void setRollNo(String rollNo)
	{
		this.rollNo = rollNo;
	}

	public String getHostel()
	{
		return hostel;
	}

	public void setHostel(String hostel)
	{
		this.hostel = hostel;
	}

	public double getCGPA()
	{
		return CGPA;
	}

	public void setCGPA(double cGPA)
	{
		CGPA = cGPA;
	}

	public int getSemester()
	{
		return semester;
	}

	public void setSemester(int semester)
	{
		this.semester = semester;
	}

	public int getCreditsEarned()
	{
		return creditsEarned;
	}

	public void setCreditsEarned(int creditsEarned)
	{
		this.creditsEarned = creditsEarned;
	}

	public int getCurrentSemesterCreditsTotal()
	{
		return currentSemesterCreditsTotal;
	}

	public void setCurrentSemesterCreditsTotal(int currentSemesterCreditsTotal)
	{
		this.currentSemesterCreditsTotal = currentSemesterCreditsTotal;
	}

	public int getCurrentSemesterCreditsEarned()
	{
		return currentSemesterCreditsEarned;
	}

	public void setCurrentSemesterCreditsEarned(int currentSemesterCreditsEarned)
	{
		this.currentSemesterCreditsEarned = currentSemesterCreditsEarned;
	}

	public Faculty getFacAd()
	{
		return facAd;
	}

	public void setFacAd(Faculty facAd)
	{
		this.facAd = facAd;
	}
	
	//Not an overridden method.
	public void sendMail()
	{
		System.out.println("Sending mail to Faculty Advisor");
		facAd.receiveMail();
	}
	
	//Not an overridden method.
	public void checkCredits()
	{
		if(currentSemesterCreditsEarned < currentSemesterCreditsTotal)
			this.sendMail();
		else
			return;
	}
	
	public void printLongBio()
	{
		this.printShortBio();
		System.out.println("Roll no: " + this.rollNo);
		System.out.println("Hostel: "+this.hostel);
		System.out.println("CGPA: "+this.CGPA);
		System.out.println("Semester: " + this.semester);
		System.out.println("Credits required this semesters: "+currentSemesterCreditsTotal);
		System.out.println("Credits earned this semester: "+currentSemesterCreditsEarned);
		System.out.println("Total Credits earned :"+creditsEarned);
		System.out.println("Faculty Advisor: "+this.facAd.name);
	}
}
