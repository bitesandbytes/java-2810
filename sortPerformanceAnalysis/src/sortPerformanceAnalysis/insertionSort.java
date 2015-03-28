package sortPerformanceAnalysis;
/*
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab
 * Insertion Sort
 */

import java.util.List;
public class insertionSort 
{	
	public static <T extends Comparable<T>> void sort(List<T> lst)
	{
		int i=1, j=0;
		T temp;
		T comp;
		int nums = lst.size();
		//If the array contains only one item.
		if(nums==0)
			return ;
		for(i=1;i<nums;i++)
		{
			temp = lst.get(i);
			j=i;
			while(j > 0)
			{
				comp = lst.get(j-1);
				if(comp.compareTo(temp) > 0) 
					lst.set(j, comp);
				else
					break;
				j--;
			}
			lst.set(j,temp);
		}
		return ;
	}
}
