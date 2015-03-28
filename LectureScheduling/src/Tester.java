/*
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab
 * Tester Class - To perform lecture scheduling.
 * Command Line Arguments - <inputFile.txt>
 */

import java.util.*;
import java.io.*;

public class Tester 
{
	//Converts 't' into 24 hr format.
	private static Time processTime(Time t, boolean isMorning)
	{
		if(t.hh < 8)
			t.hh+=12;
		if(!isMorning && t.hh == 8 && t.mm <= 0)
			t.hh=20;
		return t;
	}
	
	public static void main(String[] args) throws FileNotFoundException
	{
		System.setIn(new FileInputStream(args[0]));
		PriorityQueue<Lecture> lectures = new PriorityQueue<Lecture>();
		PriorityQueue<LectureAttendee> attendees = new PriorityQueue<LectureAttendee>();
		PriorityQueue<LectureAttendee> tempAttendees = new PriorityQueue<LectureAttendee>();
		int lectureCount, attendeeCount;
		
		Scanner in = new Scanner(System.in);
		attendeeCount = in.nextInt();
		lectureCount = in.nextInt();
		for(int i=0;i<attendeeCount;i++)
			attendees.add(new LectureAttendee());
		Time startTime = new Time(0,0), endTime = new Time(0,0);
		int hh, mm;
		String input = in.nextLine();
		String[] times = null;
		String[] start = null;
		String[] end = null;
		while(lectureCount>0)
		{
			input = in.nextLine();
			times = input.split(" ");
			start = times[0].split(":");
			hh = Integer.valueOf(start[0]);
			mm = Integer.valueOf(start[1]);
			startTime = processTime(new Time(hh,mm), true);
			end = times[1].split(":");
			hh = Integer.valueOf(end[0]);
			mm = Integer.valueOf(end[1]);
			endTime = processTime(new Time(hh,mm), false);
			lectures.add(new Lecture(startTime, endTime));
			lectureCount--;
		}
		LectureAttendee curAttendee;
		Lecture curLecture;
		int totalAttendedCount = 0;
		while(!lectures.isEmpty())
		{
			curLecture = lectures.remove();
			while(!attendees.isEmpty())
			{
				curAttendee = attendees.remove();
				
				//Check if the current person can attend the lecture.
				if(curAttendee.getsFree().compareTo(curLecture.getStartTime())<=0)
				{
					curAttendee.AttendingLecture(curLecture);
					totalAttendedCount++;
					attendees.addAll(tempAttendees);
					tempAttendees.clear();
					attendees.add(curAttendee);
					break;
				}
				//If that person cannot, then check with the next person.
				else
					tempAttendees.add(curAttendee);
			}
			if(attendees.isEmpty())
				attendees.addAll(tempAttendees);
		}
		
		System.out.println(totalAttendedCount);
		in.close();
	}
}
