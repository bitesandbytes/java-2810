/*
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab
 * Generic Binomial Max Heap Node Implementation
 * 
 */

import java.util.*;

@SuppressWarnings("rawtypes")
public class Node<T extends Comparable> implements Comparable<Node<T>>
{
	public T data;
	public int degree;
	public Node<T> parent;
	public ArrayList<Node<T>> children;
	
	public Node(T data)
	{
		this.data = data;
		degree = 1;
		parent = null;
		children = new ArrayList<Node<T>>();
	}
	
	public Node()
	{
		data = null;
		degree = 0;
		parent = null;
		children = null;
	}
	
	//Higher priority for nodes with low degree.
	public int compareTo(Node<T> other)
	{
		return (new Integer(this.degree)).compareTo(new Integer(other.degree));
	}
}
