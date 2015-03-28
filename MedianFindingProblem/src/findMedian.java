/*
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab
 * Finding Median of Input Data Stream in O(log(N)) time.
 *
 */

import java.util.*;

public class findMedian
{
	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		BinomialMinHeap<Integer> largerThanMedian = new BinomialMinHeap<Integer>();
		BinomialMaxHeap<Integer> smallerThanMedian = new BinomialMaxHeap<Integer>();
		Integer curInput, curMedian = null;
		Scanner in = new Scanner(System.in);
		boolean firstElement = true;
		while(true)
		{
			curInput = in.nextInt();
			//Odd number of inputs so far.
			if(curMedian == null)
			{
				if(firstElement)
				{
					curMedian = curInput;
					firstElement = false;
				}
				else if(curInput.compareTo(largerThanMedian.minNode.data) > 0)
				{
					curMedian = largerThanMedian.deleteMin();
					largerThanMedian.add(curInput);
				}
				else if(curInput.compareTo(smallerThanMedian.maxNode.data) < 0)
				{
					curMedian = smallerThanMedian.deleteMax();
					smallerThanMedian.add(curInput);
				}
				else
				{
					curMedian = curInput;
				}
				System.out.println("\n"+curMedian);
			}
			//Even number of inputs so far.
			else
			{
				if(curMedian.compareTo(curInput) < 0)
				{
					smallerThanMedian.add(curMedian);
					largerThanMedian.add(curInput);
				}
				else
				{
					largerThanMedian.add(curMedian);
					smallerThanMedian.add(curInput);
				}
				System.out.println("\n"+largerThanMedian.minNode.data);
				curMedian = null;
			}
		}
	}
}
