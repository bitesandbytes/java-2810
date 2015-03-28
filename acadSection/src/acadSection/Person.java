package acadSection;

import java.util.HashSet;
import java.util.Set;

public class Person implements Comparable
{
	String name;
	char sex;
	String nationality;
	String fatherName;
	String motherName;
	String dept;
	int age;
	
	public Person()
	{
		this.name = null;
		this.sex = 0;
		this.nationality = null;
		this.fatherName = null;
		this.motherName = null;
		this.dept = null;
		this.age = 0;
	}
	
	public Person(String name, char sex, String nationality, String fatherName,
			String motherName, String dept, int age)
	{
		this.name = name;
		this.sex = sex;
		this.nationality = nationality;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.dept = dept;
		this.age = age;
	}


	public String getName()
	{
		return this.name;
	}
	
	public int compareTo(Object o)
	{
		Person other = (Person)o;
		Set <String> nameOne = new HashSet<String> ();
		for (String iter : this.getName().split(" ", 3))
			nameOne.add(iter);
		Set <String> nameTwo = new HashSet<String> ();
		for (String iter: other.getName().split(" ", 3))
			nameTwo.add(iter);
		if(nameOne.equals(nameTwo))
			return 1;
		else
			return 0;
	}
	
	public void printShortBio()
	{
		System.out.println("Name: " +this.name);
		System.out.println("Mother's Name: " + this.motherName);
		System.out.println("Father's Name: " + this.fatherName);
		System.out.println("Nationality: " + this.nationality);
		return;
	}
}
