/*
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab
 * Lecture Class - To model a lecture. 
 */

public class Lecture implements Comparable<Lecture> 
{
	private Time startTime, endTime;
	public int iterationCount;
	Lecture(Time startTime, Time endTime)
	{
		this.startTime = startTime;
		this.endTime = endTime;
		iterationCount = -1;
	}
	public Time Duration()
	{
		return startTime.getDurationTill(endTime);
	}
	public Time getStartTime()
	{
		return this.startTime;
	}
	public Time getEndTime()
	{
		return this.endTime;
	}
	public int compareTo(Lecture other)
	{
		return this.endTime.compareTo(other.endTime);
	}
	public void printLecture()
	{
		startTime.printTime();
		System.out.print(" ");
		endTime.printTime();
		System.out.print("\n");
	}
}
