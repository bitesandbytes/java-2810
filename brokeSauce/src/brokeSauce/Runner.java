/*
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab
 * Solving my calculator problem.
 * Note to TA : Pliss give me a new calculator. :P
 */

package brokeSauce;
import java.util.Scanner;

public class Runner
{
	private static int[] nums;
	private static String mask;
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		int testCaseCount = in.nextInt();
		int[] results = new int[testCaseCount];
		int i = 0;
		do
		{
			int n;
			mask = "";
			for(int i1=0;i1<10;i1++)
			{
				n = in.nextInt();
				if(n == 1)
					mask = mask + String.valueOf(i1);
			}
			int N = in.nextInt();
			nums = new int[N+1];
			findFactors(N);
			results[i] = (nums[N]+1);
			i++;
		}while(testCaseCount>i);
		System.out.println("");
		for(int i1=0;i1<testCaseCount;i1++)
		{
			if(results[i1] == 0)
				System.out.println("Impossible.");
			else
				System.out.println(results[i1]);
		}
		in.close();		
	}
	
	//Finds the factors of 'n' that can be typed by the calculator.
	public static void findFactors(int n)
	{
		if(n < 10)
		{
			if(canBeTyped(n))
				nums[n] = 1;
			else
				nums[n] = -1;
			return;
		}
		if(canBeTyped(n))
		{
			nums[n] = getLength(n);
			return ;
		}
		int curValue = -1;
		int minValue = -1;
		int curFactor = (int) Math.sqrt(n) - 1;
		while(curFactor < n)
		{
			curFactor++;
			while(n % curFactor != 0 && curFactor < n)
				curFactor++;
			if(curFactor == n)
				break;
			if(nums[curFactor] == 0)
				findFactors(curFactor);
			if(nums[n/curFactor] == 0)
				findFactors(n/curFactor);
			if(nums[curFactor]< 0 || nums[n/curFactor]< 0)
				continue;
			curValue = nums[curFactor] + 1 + nums[n/curFactor];
			if(minValue == -1 || (curValue < minValue && minValue > 0))
				minValue = curValue;
		}
		nums[n] = minValue;
		return ;
	}
	
	
	//Checks if you can type 'n' using the mask.
	public static boolean canBeTyped(int n)
	{
		String[] s = String.valueOf(n).split("(?!^)");
		for(String digit : s)
			if(mask.indexOf(digit) == -1)
				return false;
		return true;
	}
	
	//Returns the length of the string.
	public static int getLength(int n)
	{
		String rep = String.valueOf(n);
		return rep.length();
	}
}
