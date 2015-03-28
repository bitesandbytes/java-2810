/*
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab
 * Generic Binomial Max Heap Implementation
 * 
 */

import java.util.*;

@SuppressWarnings("rawtypes")
public class BinomialMaxHeap<T extends Comparable>
{
	public ArrayList<Node<T>> rootList;
	public Node<T> maxNode;
	
	public BinomialMaxHeap()
	{
		rootList = new ArrayList<Node<T>>();
		maxNode = null;
	} 
	
	@SuppressWarnings("unchecked")
	public void add(T data)
	{
		Node<T> newNode = new Node<T>(data);
		//Case 1: Empty heap.
		if(rootList.size() == 0)
		{			
			rootList.add(newNode);
			maxNode = newNode;
			return;
		}
		
		//Case 2: Non-empty rootList.
		BinomialMaxHeap<T> tempHeap = new BinomialMaxHeap<T>();
		tempHeap.rootList.add(newNode);
		this.mergeWith(tempHeap);
		if(maxNode.data.compareTo(newNode.data) > 0)
			maxNode = newNode;
		tempHeap = null;
		updateMax();
		return;		
	}
	
	public T deleteMax()
	{
		if(maxNode == null)
			return null;
		BinomialMaxHeap<T> tempHeap = new BinomialMaxHeap<T> ();
		for(Node<T> child : maxNode.children)
		{
			child.parent = null;
			tempHeap.rootList.add(child);
		}
		this.rootList.remove(maxNode);
		maxNode.children.clear();
		T returnData = maxNode.data;
		this.mergeWith(tempHeap);
		tempHeap = null;
		updateMax();
		return returnData;
	}

	@SuppressWarnings("unchecked")
	private void updateMax()
	{
		if(rootList.size() == 0)
		{
			maxNode = null;
			return;
		}
		maxNode = rootList.get(0);
		for(Node<T> node : rootList)
		{
			if(node.data.compareTo(maxNode.data) > 0)
				maxNode = node;
		}
	}


	@SuppressWarnings("unchecked")
	public void mergeWith(BinomialMaxHeap<T> otherHeap)
	{
		ArrayList<Node<T>> newRootList = new ArrayList<Node<T>>();
		PriorityQueue<Node<T>> tempRootList = new PriorityQueue<Node<T>>();
		Node<T> curNode, nextNode, furtherNextNode;
		tempRootList.addAll(this.rootList);
		tempRootList.addAll(otherHeap.rootList);
		int compResult = 0;
		while(!tempRootList.isEmpty())
		{
			curNode = tempRootList.remove();
			nextNode = tempRootList.peek();
			
			//Case 0: nextNode = null;
			if(nextNode == null)
			{
				newRootList.add(curNode);
				break;
			}
			
			//Case 1: nextNode.degree > this.degree
			if(curNode.compareTo(nextNode) < 0)
			{
				newRootList.add(curNode);
				continue;
			}
			
			//Case 2: nextNode.degree = this.degree
			nextNode = tempRootList.remove();
			furtherNextNode = tempRootList.peek();
			
			if(furtherNextNode!=null)
			{
				if(curNode.compareTo(furtherNextNode) == 0)
				{
					furtherNextNode = tempRootList.remove();
					newRootList.add(furtherNextNode);
				}
			}
			compResult = curNode.data.compareTo(nextNode.data);
			if(compResult < 0)
			{
				makeChild(curNode, nextNode);
				tempRootList.add(curNode);
			}
			else
			{
				makeChild(nextNode, curNode);
				tempRootList.add(nextNode);
			}
		}	
		this.rootList = newRootList;
	}
	private void makeChild(Node<T> parent, Node<T> child)
	{
		parent.children.add(child);
		child.parent = parent;
		parent.degree++;
		return;
	}
	public void print()
	{
		for(Node<T> node : this.rootList)
			printBFS(node);
		for(Node<T> node : this.rootList)
			System.out.print(node.data+" ");
		
	}

	private void printBFS(Node<T> node)
	{
		Queue<Node<T>> bfsQueue = new LinkedList<Node<T>>();
		bfsQueue.add(node);
		Node<T> tempNode;
		while(!bfsQueue.isEmpty())
		{
			tempNode = bfsQueue.remove();
			System.out.print(tempNode.data+" ");
			bfsQueue.addAll(tempNode.children);
		}
		System.out.print("\n");
	}
}