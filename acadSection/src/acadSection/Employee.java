package acadSection;

public class Employee extends Person
{
	double basicPay;
	String empID;
	
	public Employee()
	{
		super();
		this.basicPay = 0;
		this.empID = null;
	}
	public Employee(String name, char sex, String nationality, String fatherName,
			String motherName, String dept, int age)
	{
		super(name, sex, nationality, fatherName, motherName, dept, age);
		basicPay = 0;
		empID = null;
	}
	
	
	
	public double getBasicPay()
	{
		return basicPay;
	}
	public void setBasicPay(double basicPay)
	{
		this.basicPay = basicPay;
	}
	
	//This method will be overridden in the subclasses.
	public String getID()
	{
		return empID;
	}
	
	//This method will be overridden in the subclasses.
	public void setID(String empID)
	{
		this.empID = empID;
	}	
}
