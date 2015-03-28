/*
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab
 * Runner class to test AVL Tree implementation.
 */

import java.util.*;

public class Runner
{
	public static void main(String[] args)
	{
		AVLTree<Integer> tree = new AVLTree<Integer>();
		Scanner in = new Scanner(System.in);
		Integer input = in.nextInt();
		while(true)
		{
			if(tree.find(input) != null)
				tree.remove(input);
			else
				tree.insert(input);
			
			input = in.nextInt();
			if(input == -1)
			{
				tree.print();
				break;
			}
		}
		in.close();
 	}
}
