package sortPerformanceAnalysis;
/*
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab
 * Test Performance of String type Array List
 */
import java.util.List;
import java.util.Random;
public class testStringArrayListPerformance
{
	private static final int largestSize = 1000000;
	
	public static double getAverageOf15(double[] arr)
	{
		double sum=0;
		for(int i=5;i<15;i++)
			sum+=arr[i];
		return (sum/10); 
	}
	public static void analyzeMergeSort()
	{
		System.out.println("\n\nMerge Sort on String Array Lists.");
		Random randomObject = new Random();
		int size = 10;
		List<String> lst;
		double[] times = new double[15];
		for(;size <= largestSize; size*=10)
		{
			System.out.print("Size = "+size);
			for(int i =0;i<15;i++)
			{
				lst = testUtils.getRandomStringArrayList(size, randomObject);
				times[i] = testUtils.mergeSortTime(lst);
			}
			System.out.print("\tAverage execution time = "+getAverageOf15(times)+"\n");
		}
	}
	public static void analyzeMergeSortBottomOut()
	{
		System.out.println("\n\nMerge Sort on String Array Lists, Bottom out at 10.");
		Random randomObject = new Random();
		int size = 10;
		List<String> lst;
		double[] times = new double[15];
		for(;size <= largestSize; size*=10)
		{
			System.out.print("Size = "+size);
			for(int i =0;i<15;i++)
			{
				lst = testUtils.getRandomStringArrayList(size, randomObject);
				times[i] = testUtils.mergeSortTimeBottomOut(lst);
			}
			System.out.print("\tAverage execution time = "+getAverageOf15(times)+"\n");
		}
	}
	
	public static void runTest()
	{
		analyzeMergeSort();
		analyzeMergeSortBottomOut();
	}
}
