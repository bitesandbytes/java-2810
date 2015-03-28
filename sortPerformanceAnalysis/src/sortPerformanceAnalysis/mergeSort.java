package sortPerformanceAnalysis;

/*
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab
 * Merge Sort
 */
import java.util.List;
public class mergeSort
{
	@SuppressWarnings("unchecked")
	private static <T extends Comparable <T>> List<T> merge (List<T> lstA, List<T> lstB,Class<?> cls) throws InstantiationException, IllegalAccessException 
	{
		List<T> lst = (List<T>) cls.newInstance();
		int ptrA =0;
		int ptrB = 0;
		int sizeA = lstA.size();
		int sizeB = lstB.size();
		T temp1, temp2;
		while(ptrA<sizeA && ptrB<sizeB)
		{
			temp1 = lstA.get(ptrA);
			temp2 = lstB.get(ptrB);
			if(temp1.compareTo(temp2) < 0)
			{
				lst.add(temp1);
				ptrA++;
			}
			else
			{
				lst.add(temp2);
				ptrB++;
			}
		}
		while(ptrA<sizeA)
		{
			lst.add(lstA.get(ptrA));
			ptrA++;
		}
		while(ptrB<sizeB)
		{
			lst.add(lstB.get(ptrB));
			ptrB++;
		}
		return lst;
	}
	
	private static <T extends Comparable <T>> List<T> internalSort(List<T> lst, Class<?> c)
	{
		if(lst.size() <2 )
			return lst;
		if(lst.size()==2)
		{
			T el1 = lst.get(0);
			T el2 = lst.get(1);
			try
			{
				@SuppressWarnings("unchecked")
				List<T> list = (List<T>)c.newInstance();
				if(el1.compareTo(el2) < 0)
				{
					list.add(el1);
					list.add(el2);
				}
				else
				{
					list.add(el2);
					list.add(el1);
				}
				return list;
			}
			catch(IllegalAccessException ex)
			{
				ex.printStackTrace();
			}
			catch(InstantiationException ex2)
			{
				ex2.printStackTrace();
			}
			return lst;
		}
		int split = lst.size()/2;
		List<T> right = (List<T>)lst.subList(0, split);
		List<T> left = (List<T>)lst.subList(split, lst.size());
		left = internalSort(left, c);
		right = internalSort(right,c);
		try
		{
			return merge(left,right,c);
		}
		catch(IllegalAccessException ex)
		{
			ex.printStackTrace();
		}
		catch(InstantiationException ex2)
		{
			ex2.printStackTrace();
		}
		return lst;
	}
	
	private static <T extends Comparable <T>> List<T> internalSortBottomOut(List<T> lst, Class<?> c)
	{
		if(lst.size()<=10)
		{
			insertionSort.sort(lst);
			return lst;
		}
		int split = lst.size()/2;
		List<T> right = (List<T>)lst.subList(0, split);
		List<T> left = (List<T>)lst.subList(split, lst.size());
		left = internalSort(left, c);
		right = internalSort(right,c);
		try
		{
			return merge(left,right,c);
		}
		catch(IllegalAccessException ex)
		{
			ex.printStackTrace();
		}
		catch(InstantiationException ex2)
		{
			ex2.printStackTrace();
		}
		return lst;
		
	}
	
	public static <T extends Comparable<T>> List <T> sort(List<T> lst)
	{
		return internalSort(lst,lst.getClass());
	}
	public static <T extends Comparable<T>> List <T> sortBottomOut(List<T> lst, int k)
	{
		//Bottom out at 2 elements.
		if(lst.size() <= k)
		{
			insertionSort.sort(lst);
			return lst;
		}
		return internalSortBottomOut(lst,lst.getClass());		
	}
}
