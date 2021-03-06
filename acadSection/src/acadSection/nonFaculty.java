package acadSection;

public class nonFaculty extends Employee 
{
	String nonFacultyID;
	String department;
	
	public nonFaculty()
	{
		super();
		department = null;
		nonFacultyID = null;
	}
	
	public nonFaculty(String name, char sex, String nationality, String fatherName,
			String motherName, String dept, int age)
	{
		super(name, sex, nationality, fatherName, motherName, dept, age);
		this.nonFacultyID = null;
		this.department = null;
	}

	@Override
	public String getID()
	{
		return nonFacultyID;
	}
	
	@Override
	public void setID(String nonFacultyID)
	{
		this.nonFacultyID = nonFacultyID;
	}
		
	public String getDepartment()
	{
		return department;
	}

	public void setDepartment(String department)
	{
		this.department = department;
	}
}