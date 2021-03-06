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
		AVLTree<Integer> treeAVL = new AVLTree<Integer>();
		BSTree<Integer> treeBST = new BSTree<Integer>();
		Scanner in = new Scanner(System.in);
		Integer input = in.nextInt();
		while(true)
		{
			if(treeAVL.find(input) != null)
				treeAVL.remove(input);
			else
				treeAVL.insert(input);
			
			if(treeBST.find(input) != null)
				treeBST.remove(input);
			else
				treeBST.insert(input);
			
			input = in.nextInt();
			if(input == -1)
			{
				treeAVL.print();
				treeBST.print();
				break;
			}
		}
		in.close();
 	}
}
