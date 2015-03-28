/*
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab
 * LectureAttendee Class - To model a person attending a lecture. 
 */

public class LectureAttendee implements Comparable<LectureAttendee>
{
	private int lecturesAttendedCount;
	private Time getsFreeAt;
	public LectureAttendee() 
	{
		lecturesAttendedCount = 0;
		getsFreeAt = new Time(-5,0);
	}
	public void AttendingLecture(Lecture lec)
	{
		this.getsFreeAt = lec.getEndTime();
		lecturesAttendedCount++;
	}
	public Time getsFree()
	{
		return getsFreeAt;
	}
	public int compareTo(LectureAttendee other)
	{
		return (this.getsFreeAt.compareTo(other.getsFreeAt)* -1);
	}
	public int getAttendedLecturesCount()
	{
		return lecturesAttendedCount;
	}
	public void printTiming()
	{
		System.out.print("Gets free at: ");
		getsFreeAt.printTime();
		System.out.print("\n");
	}
}
