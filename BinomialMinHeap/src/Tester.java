/*
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab
 * Test Class.
 * 
 */

import java.util.*;

public class Tester
{
	public static void main(String[] args)
	{
		BinomialMinHeap<Integer> treeA, treeB;
		treeA = new BinomialMinHeap<Integer>();
		treeB = new BinomialMinHeap<Integer>();
		int m, n;
		Scanner in = new Scanner(System.in);
		m = in.nextInt();
		n = in.nextInt();
		for(int i=0;i<m;i++)
			treeA.add(new Integer(in.nextInt()));
		for(int i=0;i<n;i++)
			treeB.add(new Integer(in.nextInt()));
		treeA.mergeWith(treeB);
		System.out.println("\n");
		treeA.print();		
		in.close();
	}
}
