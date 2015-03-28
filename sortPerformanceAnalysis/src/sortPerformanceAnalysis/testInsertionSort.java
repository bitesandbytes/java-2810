package sortPerformanceAnalysis;
/*
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab
 * Test Insertion Sort
 */
import java.util.List;
import java.util.Random;
public class testInsertionSort
{
	private static int LargestSize = 100000;
	private static int largestSize = 1000;
	
	public static void analyzeIntArrayList()
	{
		System.out.println("\n\nInsertion on Integer Array Lists.");
		Random randomObject = new Random();
		int size = 10;
		List<Integer> lst;
		double[] times = new double[15];
		for(;size <= LargestSize; size*=10)
		{
			System.out.print("Size = "+size);
			for(int i =0;i<5;i++)
			{
				lst = testUtils.getRandomIntArrayList(size, randomObject);
				times[i] = testUtils.insertionSortTime(lst);
			}
			System.out.print("\tAverage execution time = "+times[3]+"\n");
		}
	}
	public static void analyzeFloatArrayList()
	{
		System.out.println("\n\nInsertion on Float Array Lists.");
		Random randomObject = new Random();
		int size = 10;
		List<Float> lst;
		double[] times = new double[15];
		for(;size <= LargestSize; size*=10)
		{
			System.out.print("Size = "+size);
			for(int i =0;i<5;i++)
			{
				lst = testUtils.getRandomFloatArrayList(size, randomObject);
				times[i] = testUtils.insertionSortTime(lst);
			}
			System.out.print("\tAverage execution time = "+times[3]+"\n");
		}
	}
	public static void analyzeStringArrayList()
	{
		System.out.println("\n\nInsertion on String Array Lists.");
		Random randomObject = new Random();
		int size = 10;
		List<String> lst;
		double[] times = new double[15];
		for(;size <= LargestSize; size*=10)
		{
			System.out.print("Size = "+size);
			for(int i =0;i<5;i++)
			{
				lst = testUtils.getRandomStringArrayList(size, randomObject);
				times[i] = testUtils.insertionSortTime(lst);
			}
			System.out.print("\tAverage execution time = "+times[3]+"\n");
		}
	}
	public static void analyzeIntLinkedList()
	{
		System.out.println("\n\nInsertion on Integer Linked Lists.");
		Random randomObject = new Random();
		int size = 10;
		List<Integer> lst;
		double[] times = new double[15];
		for(;size <= largestSize; size*=10)
		{
			System.out.print("Size = "+size);
			for(int i =0;i<5;i++)
			{
				lst = testUtils.getRandomIntLinkedList(size, randomObject);
				times[i] = testUtils.insertionSortTime(lst);
			}
			System.out.print("\tAverage execution time = "+times[3]+"\n");
		}
	}
	public static void analyzeFloatLinkedList()
	{
		System.out.println("\n\nInsertion on Float Linked Lists.");
		Random randomObject = new Random();
		int size = 10;
		List<Float> lst;
		double[] times = new double[15];
		for(;size <= largestSize; size*=10)
		{
			System.out.print("Size = "+size);
			for(int i =0;i<5;i++)
			{
				lst = testUtils.getRandomFloatLinkedList(size, randomObject);
				times[i] = testUtils.insertionSortTime(lst);
			}
			System.out.print("\tAverage execution time = "+times[3]+"\n");
		}
	}
	public static void analyzeStringLinkedList()
	{
		System.out.println("\n\nInsertion on String Linked Lists.");
		Random randomObject = new Random();
		int size = 10;
		List<String> lst;
		double[] times = new double[15];
		for(;size <= largestSize; size*=10)
		{
			System.out.print("Size = "+size);
			for(int i =0;i<5;i++)
			{
				lst = testUtils.getRandomStringLinkedList(size, randomObject);
				times[i] = testUtils.insertionSortTime(lst);
			}
			System.out.print("\tAverage execution time = "+times[3]+"\n");
		}
	}
	public static void runTest()
	{
		analyzeIntArrayList();
		analyzeStringArrayList();
		analyzeIntLinkedList();
		analyzeStringLinkedList();
	}
}
