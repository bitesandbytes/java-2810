package serial;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

/**
 * @author Sauce (CS13B056)
 *
 */
public class StudentPersist {

	/**
	 * @param list 
	 * @param args
	 */
	public static void persist(List<StudentDetails> list) 
	{
		try
		{
			FileOutputStream fout = new FileOutputStream("student.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			int max = list.size();
			for(int i=0;i<max;i++)
			{
				oos.writeObject(list.get(i));
			}
			oos.close();
		}
		
		//Ignore this exception.
		catch(IOException ex)
		{
			
		}
	}
}
