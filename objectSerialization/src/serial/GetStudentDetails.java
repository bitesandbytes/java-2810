package serial;
/**
 * @author Sauce(CS13B056)
 *
 */

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GetStudentDetails {

	/**
	 * @param args
	 */
	
	//Prints the details of a StudentDetails object in tuple form.
	private static void printStudent(List<StudentDetails> list)
	{
		int end = list.size();
		StudentDetails temp;
		for(int i=0;i<end;i++)
		{
			temp = list.get(i);
			System.out.println("("+temp.getName()+","+temp.getAge()+","+temp.getgender()+")" );
		}
		return;
	}
	public static void retrieve() 
	{
		List <StudentDetails> details = new ArrayList<StudentDetails>();
		ObjectInputStream ois = null;
		try
		{
			ois = new ObjectInputStream(new FileInputStream("student.txt"));
			while(true)
				details.add((StudentDetails)ois.readObject());
		}
		
		//Ignore this exception.
		catch(IOException ex)
		{
			
		}
		
		//This exception is serious.
		catch(ClassNotFoundException ex1)
		{
			System.out.println("Class not found.");
		}
		finally
		{
			Collections.sort(details);
			printStudent(details);
		}
	}

}
