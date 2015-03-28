/*
 * Author : Sauce (CS13B056) 
 * CS2810 - Advanced Programming Lab 
 * AVL Tree implementation.
 */
import java.util.*;

public class AVLTree<T extends Comparable<T>>
{
	Node<T> treeRoot;
	Queue<Node<T>> queue;
	Node<T> lastDeletedNode;

	AVLTree()
	{
		treeRoot = null;
		queue = new LinkedList<Node<T>>();
		lastDeletedNode = null;
	}

	// Inserts 'data' into the AVL Tree.
	public void insert(T data)
	{
		Node<T> newNode = new Node<T>(data);
		Node<T> unbalancedNode;
		if (treeRoot != null)
		{
			BSTInsert(treeRoot, newNode);
			updateBalanceRetrace(newNode);
			unbalancedNode = findUnbalancedNode(newNode);
			if (unbalancedNode != null)
				balance(unbalancedNode);
		}
		else
			treeRoot = newNode;
		System.out.print("AVL Tree -> ");
		printBFS();
		if (treeRoot != null)
			System.out.println("AVL Tree Height = " + treeRoot.height);
	}

	// Returns the location of 'data' if found in the AVL Tree.
	public Node<T> find(T data)
	{
		return recursiveFind(treeRoot, data);
	}

	// Removes 'removeData' from AVL Tree, if it exists.
	public void remove(T removeData)
	{
		treeRoot = BSTRemove(treeRoot, removeData);
		updateBalanceRetrace(lastDeletedNode);
		Node<T> unbalancedNode = findUnbalancedNode(lastDeletedNode);
		if (unbalancedNode != null)
			balance(unbalancedNode);
		lastDeletedNode = null;
		System.out.print("AVL Tree -> ");
		printBFS();
		if (treeRoot != null)
			System.out.println("AVL Tree Height = " + treeRoot.height);
	}

	// Prints the AVL Tree in sorted manner.
	public void print()
	{
		System.out.print("AVL Tree -> ");
		if (treeRoot == null)
			return;
		else
			BSTPrint(treeRoot);
		System.out.println("");
	}

	// Prints the AVL Tree in BFS manner.
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private void printBFS()
	{
		if (treeRoot == null)
			return;
		queue.add(treeRoot);
		Node node = new Node(Integer.MIN_VALUE);
		Node<T> dummyNode = (Node<T>) node;
		queue.add(dummyNode);
		Node<T> curNode = null;
		while (!queue.isEmpty())
		{
			curNode = queue.poll();
			if (queue.isEmpty())
				break;
			if (curNode.compareTo(dummyNode) == 0)
			{
				System.out.print(" # ");
				queue.add(dummyNode);
				continue;
			}
			System.out.print(curNode.data + " ");
			if (curNode.left != null)
				queue.add(curNode.left);
			if (curNode.right != null)
				queue.add(curNode.right);
		}
		System.out.println("");
		queue.clear();
		return;
	}

	// Print routine from BST.
	private void BSTPrint(Node<T> root)
	{
		if (root == null)
			return;
		BSTPrint(root.left);
		System.out.print(root.data + " ");
		BSTPrint(root.right);
		return;
	}

	// Remove routine from BST.
	public Node<T> BSTRemove(Node<T> root, T data)
	{
		if (root == null)
		{
			System.out.println("Data not found in tree.");
			return null;
		}
		if (root.data.compareTo(data) > 0)
			root.left = BSTRemove(root.left, data);
		else if (root.data.compareTo(data) < 0)
			root.right = BSTRemove(root.right, data);
		else
		{
			if (root.left == null)
			{
				if (root.right == null)
				{
					lastDeletedNode = root.parent;
					return null;
				}
				else
				{
					lastDeletedNode = root.right;
					root.right.parent = root.parent;
				}
				return root.right;
			}
			else if (root.right == null)
			{
				lastDeletedNode = root.left;
				root.left.parent = root.parent;
				return root.left;
			}
			Node<T> minNode = findMin(root.right);
			root.data = minNode.data;
			root.right = BSTRemove(root.right, root.data);
		}
		return root;
	}

	// Finds 'data' in subtree rooted at 'root'.
	private Node<T> recursiveFind(Node<T> root, T data)
	{
		if (root == null)
			return null;
		int result = root.data.compareTo(data);
		if (result == 0)
			return root;
		else if (result < 0)
			return recursiveFind(root.right, data);
		else
			return recursiveFind(root.left, data);
	}

	// Balances the AVL Tree near 'unbalancedNode'.
	private void balance(Node<T> unbalancedNode)
	{
		boolean isLeftOfAncestor, isLeftOfParent;
		Node<T> ancestor = unbalancedNode;
		Node<T> parent, child;

		if (ancestor.balanceFactor > 0)
		{
			parent = ancestor.left;
			isLeftOfAncestor = true;
		}
		else
		{
			parent = ancestor.right;
			isLeftOfAncestor = false;
		}
		if (parent.balanceFactor > 0)
		{
			child = parent.left;
			isLeftOfParent = true;
		}
		else
		{
			child = parent.right;
			isLeftOfParent = false;
		}

		if (isLeftOfAncestor && isLeftOfParent)
		{
			rightRotate(ancestor);
			updateBalance(ancestor);
			updateBalanceRetrace(child);
		}
		else if (isLeftOfAncestor && !isLeftOfParent)
		{
			leftRotate(parent);
			rightRotate(ancestor);
			updateBalance(ancestor);
			updateBalanceRetrace(parent);
		}
		else if (!isLeftOfAncestor && isLeftOfParent)
		{
			rightRotate(parent);
			leftRotate(ancestor);
			updateBalance(parent);
			updateBalanceRetrace(ancestor);
		}
		else
		{
			leftRotate(ancestor);
			updateBalance(child);
			updateBalanceRetrace(ancestor);
		}
		unbalancedNode = findUnbalancedNode(ancestor);
		if (unbalancedNode != null)
			balance(unbalancedNode);
		return;
	}

	// Updates the balance factors till root is reached.
	private void updateBalanceRetrace(Node<T> root)
	{
		if (root == null)
			return;
		else
		{
			updateBalance(root);
			updateBalanceRetrace(root.parent);
		}
	}

	// Updates the balance factor for 'root'.
	private void updateBalance(Node<T> root)
	{
		root.height = max(height(root.left), height(root.right)) + 1;
		root.balanceFactor = height(root.left) - height(root.right);
		return;
	}

	// Returns height of 'root'.
	private int height(Node<T> root)
	{
		if (root == null)
			return -1;
		else
			return root.height;
	}

	// Returns max of 'a' and 'b'.
	private int max(int a, int b)
	{
		if (a < b)
			return b;
		else
			return a;
	}

	// Performs a standard BST insert.
	private void BSTInsert(Node<T> root, Node<T> insertNode)
	{
		if (root.compareTo(insertNode) > 0)
		{
			if (root.left == null)
			{
				root.left = insertNode;
				insertNode.parent = root;
			}
			else
				BSTInsert(root.left, insertNode);
		}
		else
		{
			if (root.right == null)
			{
				root.right = insertNode;
				insertNode.parent = root;
			}
			else
				BSTInsert(root.right, insertNode);
		}
		return;
	}

	// Finds an unbalanced ancestor.
	private Node<T> findUnbalancedNode(Node<T> root)
	{
		if (root == null)
			return null;

		if (root.balanceFactor < -1 || root.balanceFactor > 1)
			return root;
		else
			return findUnbalancedNode(root.parent);
	}

	// Does a left rotate about 'oldRoot'.
	private void leftRotate(Node<T> oldRoot)
	{
		Node<T> parent = oldRoot.parent;
		Node<T> newRoot = oldRoot.right;
		Node<T> alpha = newRoot.left;

		oldRoot.parent = newRoot;
		newRoot.parent = parent;
		newRoot.left = oldRoot;
		oldRoot.right = alpha;

		if (alpha != null)
			alpha.parent = oldRoot;

		if (parent == null)
			treeRoot = newRoot;
		else if (oldRoot.compareTo(parent.left) == 0)
			parent.left = newRoot;
		else
			parent.right = newRoot;
		return;
	}

	// Does a right rotate about 'oldRoot'.
	private void rightRotate(Node<T> oldRoot)
	{
		Node<T> parent = oldRoot.parent;
		Node<T> newRoot = oldRoot.left;
		Node<T> alpha = newRoot.right;

		oldRoot.parent = newRoot;
		newRoot.parent = parent;
		newRoot.right = oldRoot;
		oldRoot.left = alpha;

		if (alpha != null)
			alpha.parent = oldRoot;
		if (parent == null)
			treeRoot = newRoot;
		else if (oldRoot.compareTo(parent.left) == 0)
			parent.left = newRoot;
		else
			parent.right = newRoot;
		return;
	}

	// Finds the minimum value node in subtree rooted at 'root'.
	private Node<T> findMin(Node<T> root)
	{
		if (root == null)
			return null;
		if (root.left == null)
			return root;
		else
			return findMin(root.left);
	}
}
