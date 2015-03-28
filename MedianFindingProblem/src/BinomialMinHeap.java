/*
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab
 * Generic Binomial Min Heap Implementation
 * 
 */

import java.util.*;

@SuppressWarnings("rawtypes")
public class BinomialMinHeap<T extends Comparable>
{
	public ArrayList<Node<T>> rootList;
	public Node<T> minNode;
	
	public BinomialMinHeap()
	{
		rootList = new ArrayList<Node<T>>();
		minNode = null;
	} 
	
	@SuppressWarnings("unchecked")
	public void add(T data)
	{
		Node<T> newNode = new Node<T>(data);
		//Case 1: Empty heap.
		if(rootList.size() == 0)
		{			
			rootList.add(newNode);
			minNode = newNode;
			return;
		}
		
		//Case 2: Non-empty rootList.
		BinomialMinHeap<T> tempHeap = new BinomialMinHeap<T>();
		tempHeap.rootList.add(newNode);
		this.mergeWith(tempHeap);
		if(minNode.data.compareTo(newNode.data) > 0)
			minNode = newNode;
		tempHeap = null;
		updateMin();
		return;		
	}
	
	public T deleteMin()
	{
		if(minNode == null)
			return null;
		BinomialMinHeap<T> tempHeap = new BinomialMinHeap<T> ();
		for(Node<T> child : minNode.children)
		{
			child.parent = null;
			tempHeap.rootList.add(child);
		}
		this.rootList.remove(minNode);
		minNode.children.clear();
		T returnData = minNode.data;
		this.mergeWith(tempHeap);
		tempHeap = null;
		updateMin();
		return returnData;
	}

	@SuppressWarnings("unchecked")
	private void updateMin()
	{
		if(rootList.size() == 0)
		{
			minNode = null;
			return;
		}
		minNode = rootList.get(0);
		for(Node<T> node : rootList)
		{
			if(node.data.compareTo(minNode.data) < 0)
				minNode = node;
		}
	}

	@SuppressWarnings("unchecked")
	public void mergeWith(BinomialMinHeap<T> otherHeap)
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