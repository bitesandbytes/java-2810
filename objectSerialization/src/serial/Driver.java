package serial;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Sauce (CS13B056)
 *
 */
public class Driver 
{

	/**
	 * @param args
	 */
	
	//Sets the attributes for a given StudentDetails object.
	public static StudentDetails setAttributes(StudentDetails student, String name, int age, String gender)
	{
		student.setAge(age);
		student.setName(name);
		student.setgender(gender);
		return student;
	}
	
	public static void main(String[] args) 
	{
		List <StudentDetails> details = new ArrayList<StudentDetails>();
		
		//Add the objects into a list.
		for(int i=0;i<11;i++)
			details.add(setAttributes(new StudentDetails(), "Person"+Integer.toString(i+10), i+20, "M"));
		
		//Persist the objects to a file using the StudentPersist class.
		StudentPersist.persist(details);
		
		//Retrieve and print them in a sorted order using the Comparable interface in the GetStudentDetails class.
		GetStudentDetails.retrieve();		
	}
}
