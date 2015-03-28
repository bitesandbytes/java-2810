/*
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab
 * Solving minimum non-negative sum problem.
 */

package minNonNegativeSum;
import java.util.*;

public class Runner
{
	public static int[] values;
	public static int limit;
	public static int offset;
	public static int[][] functionValues;
	
	//Calculates the solution to the problem.
	public static int function(int targetSum, int index)
	{
		if(index == limit)
			return 0;
		
		//Use the stored value of the function, if calculated before.
		if(functionValues[index][targetSum+offset]!=Integer.MIN_VALUE)
			return functionValues[index][targetSum+offset];
		
		//The following lines of code will implement DP in this problem.
		//Calculates the sum when the positive instance is used.
		int sumA = function(targetSum - values[index],index+1) + values[index];
		
		//Calculates the sum when the negative instance is used.
		int sumB = function(targetSum + values[index],index+1) - values[index];
		
		//Calculates the absolute differences from the targetSum.
		int diffA = Math.abs(targetSum-sumA);
		int diffB = Math.abs(targetSum-sumB);
		
		/* If solution with positive instance is closer to targetSum, then use it.
		 * Note that only absolute value of differences is used.
		 * You can always negate the entire solution to get a new solution. 
		 */
		if(diffA < diffB)
			functionValues[index][targetSum+offset] = sumA;
		else
			functionValues[index][targetSum+offset] = sumB;
		return functionValues[index][targetSum+offset];
	}
	
	public static void main(String[] args)
	{
		Scanner in = new Scanner(System.in);
		offset = 0;
		limit = in.nextInt();
		values = new int[limit];
		for(int i=0;i<limit;i++)
		{
			values[i] = in.nextInt();
			offset+=values[i];
		}
		functionValues = new int[limit][2*offset+1];
		
		//Initialize the values of the functionValues array to -INFINITY.
		for(int i=0;i<limit;i++)
			for(int j=0;j<2*offset+1;j++)
				functionValues[i][j]=Integer.MIN_VALUE;
		
		//Print the required result.
		System.out.println(Math.abs(function(0,0)));
	}
}
