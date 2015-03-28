/*
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab
 * Node class for AVL Tree implementation.
 */

public class Node<T extends Comparable<T>> implements Comparable<Node<T>>
{
	T data;
	Node<T> left, right, parent;
	int balanceFactor;
	int height;

	Node(T data)
	{
		this.data = data;
		this.left = null;
		this.right = null;
		this.parent = null;
		balanceFactor = 0;
		height = 0;
	}

	public int compareTo(Node<T> other)
	{
		if (other == null)
			return 1;
		return this.data.compareTo(other.data);
	}
}
