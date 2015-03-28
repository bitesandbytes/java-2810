package isAcyclic;
/*
 * Author : Sauce(CS13B056)
 * CS2810 -Advanced Programming Lab
 * Testing reliability of a network.
 * Runner Class
 */
import java.util.*;
import java.util.Scanner;

public class Runner
{
	//This stack maintains the stack of nodes in the current path.
	public static Stack<Vertex> currentPath = new Stack<Vertex>();
	
	//Explores a node and performs DFS on it's adjacent nodes.
	public static void explore(Vertex node)
	{		
		int size = node.neighbours.size();
		Vertex neighbour = null;
		for(int i=0;i<size;i++)
		{
			neighbour =node.neighbours.get(i); 
			
			//If already visited the node, then skip the adjacent vertex.
			if(neighbour.isVisited)
				continue;
			
			//If there happens to be a cycle.
			if(currentPath.contains(neighbour))
			{
				System.out.println("NOT RELIABLE.");
				System.exit(-1);
			}
			else
			{
				currentPath.push(neighbour);
				explore(neighbour);
				currentPath.pop();
			}
		}
	}
	
	public static void main(String[] args)
	{
		Graph G;
		int n, e, vertexA, vertexB;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		e = in.nextInt();
		
		//Build the graph.
		G = new Graph(n,e);
		for(int i=0;i<e;i++)
		{
			vertexA = in.nextInt();
			vertexB = in.nextInt();
			if(vertexA == vertexB)
			{
				System.out.println("NOT RELIABLE");
				System.exit(-1);
			}
			G.vertices[vertexA-1].neighbours.add(G.vertices[vertexB-1]);
		}
		
		//Explore each node in a DFS manner.
		for(int i=0;i<n;i++)
		{
			//If already visited the node, continue.
			if(G.vertices[i].isVisited)
				continue;
			explore(G.vertices[i]);
		}
		System.out.println("RELIABLE");		
		in.close();
	}
}
