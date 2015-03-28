import java.util.*;
/*
 * Author : Sauce(CS13B056)
 * CS2810 -Advanced Programming Lab
 * Metro Rail Network Planning
 * Kruskal's Algorithm Implementation 
 */

public class KruskalAlgo
{	
	//A list to hold the different trees in the forest.
	public static ArrayList<HashSet<Vertex>> forest = new ArrayList<HashSet<Vertex>>();
	
	//Kruskal's algorithm is implemented here.
	public static int buildMinSpanningTree(Graph graph, PriorityQueue<Edge> edges, Graph minSpanningTree)
	{
		Edge e = null;
		//Initialize the forest with all the 'n' vertices.
		HashSet<Vertex> tempHashSet = null;
		for(int i=0;i<graph.n;i++)
		{
			tempHashSet = new HashSet<Vertex>();
			tempHashSet.add(graph.vertices[i]);
			forest.add(tempHashSet);
		}
		
		int weight = 0;
		//Iterate over the list of distinct edges.
		while(!edges.isEmpty())
		{
			e = edges.poll();
			//If the addition of the edge completes a cycle, ignore this edge.
			if(!doesTheEdgeCompleteCycle(e))
			{
				joinTrees(minSpanningTree, e);
				weight += e.weight;
			}
			else
				continue;
		}
		return weight;
	}
	
	//This function checks if the edge completes a cycle in the forest.
	private static boolean doesTheEdgeCompleteCycle(Edge e)
	{
		for(HashSet<Vertex> tree: forest)
		{
			if(tree.contains(e.source) && tree.contains(e.dest))
				return true;
		}
		return false;
	}
	
	//This function joins the two trees with an edge e.
	private static void joinTrees(Graph minSpanningTree, Edge e)
	{
		HashSet<Vertex> source = null, dest = null;
		for(HashSet<Vertex> tree : forest)
		{
			if(tree.contains(e.source))
				source = tree;
			else if(tree.contains(e.dest))
				dest = tree;
			else
				continue;
		}
		
		//Add the edge to the minSpanningTree.
		Vertex sourceVertex = e.source;
		Vertex destVertex = e.dest;
		
		//Preserve the incremental order for printing.
		if(sourceVertex.vertexID < destVertex.vertexID)
		{
			minSpanningTree.vertices[sourceVertex.vertexID].edges.add(e);
		}
		else
			minSpanningTree.vertices[destVertex.vertexID].edges.add(new Edge(e.dest,e.source, e.weight));
			
		//Merge the source tree and the destination tree into one.
		source.addAll(dest);
		forest.remove(dest);
		return;
	}
}
