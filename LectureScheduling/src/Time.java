/*
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab
 * Time Class - To model time in 24HR format. 
 */

public class Time implements Comparable<Time>
{
	public int hh, mm;
	
	public Time(int hh, int mm)
	{
		this.hh = hh;
		this.mm = mm;
	}
	public Time getDurationTill(Time EndTime)
	{
		Time newTime = new Time(-5,0);
		newTime.hh = (this.hh - EndTime.hh)+12;
		newTime.mm = (this.mm - EndTime.mm);
		if(newTime.mm < 0)
		{
			newTime.hh--;
			newTime.mm+=60;
		}
		return newTime;
	}
	public int compareTo(Time other)
	{
		if(this.hh < other.hh)
			return -1;
		else if(this.hh > other.hh)
			return 1;
		else if(this.mm < other.mm)
			return -1;
		else if(this.mm > other.mm)
			return 1;
		else
			return 0;
	}
	public void printTime()
	{
		System.out.print(this.hh+":"+this.mm);
	}
}
