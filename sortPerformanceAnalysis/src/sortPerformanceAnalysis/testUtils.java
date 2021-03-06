package sortPerformanceAnalysis;
/*
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab
 * Helper functions for performance tests
 */
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
public class testUtils
{
	//Generates a random int ArrayList of size 'size' using 'randomObject'
	public static List<Integer> getRandomIntArrayList(int size, Random randomObject)
	{
		List <Integer> lst = new ArrayList <Integer>();
		for(int i=0;i<size;i++)
			lst.add(randomObject.nextInt());
		return lst;		
	}
	
	//Generates a random float ArrayList of size 'size' using 'randomObject'
	public static List<Float> getRandomFloatArrayList(int size, Random randomObject)
	{
		List <Float> lst = new ArrayList <Float>();
		for(int i=0;i<size;i++)
			lst.add(randomObject.nextFloat()*size);
		return lst;		
	}
	
	//Generates a random int LinkedList of size 'size' using 'randomObject'
	public static List<Integer> getRandomIntLinkedList(int size, Random randomObject)
	{
		List <Integer> lst = new LinkedList <Integer>();
		for(int i=0;i<size;i++)
			lst.add(randomObject.nextInt());
		return lst;		
	}
	
	//Generates a random float LinkedList of size 'size' using 'randomObject'
	public static List<Float> getRandomFloatLinkedList(int size, Random randomObject)
	{
		List <Float> lst = new LinkedList <Float>();
		for(int i=0;i<size;i++)
			lst.add(randomObject.nextFloat()*size);
		return lst;		
	}
	
	//Generates a random float LinkedList of size 'size' using 'randomObject'
	public static List<String> getRandomStringArrayList(int size, Random randomObject)
	{
		List <String> lst = new ArrayList <String>();
		for(int i=0;i<size;i++)
			lst.add(Long.toHexString(Double.doubleToLongBits(randomObject.nextDouble())));
		return lst;		
	}

	//Generates a random float LinkedList of size 'size' using 'randomObject'
	public static List<String> getRandomStringLinkedList(int size, Random randomObject)
	{
		List <String> lst = new LinkedList <String>();
		for(int i=0;i<size;i++)
			lst.add(Long.toHexString(Double.doubleToLongBits(randomObject.nextDouble())));
		return lst;		
	}
	
	
	//To measure the time taken to sort 'lst' using Merge Sort technique.
	public static <T extends Comparable<T>> double mergeSortTime(List<T> lst)
	{
		double startTime = System.nanoTime();
		mergeSort.sort(lst);
		double endTime = System.nanoTime();
		return (endTime - startTime)/1000000000;
	}

	//To measure the time taken to sort 'lst' using Merge Sort technique.
	public static <T extends Comparable<T>> double mergeSortTimeBottomOut(List<T> lst) 
	{
		double startTime = System.nanoTime();
		mergeSort.sortBottomOut(lst, 10);
		double endTime = System.nanoTime();
		return (endTime - startTime)/1000000000;
	}
	
	
	//To measure the time taken to sort 'lst' using Insertion Sort technique.
	public static <T extends Comparable<T>> double insertionSortTime(List<T> lst)
	{	
		double startTime = System.nanoTime();	
		insertionSort.sort(lst);	
		double endTime = System.nanoTime();	
		return (endTime - startTime)/1000000000;
	}	
	
}
