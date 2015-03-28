import java.util.*;
/*
 * Author : Sauce(CS13B056)
 * CS2810 -Advanced Programming Lab
 * Metro Rail Network Planning
 * Prim's Algorithm Implementation 
 */

public class PrimAlgo
{
	public static int buildMinSpanningTree(Graph graph, Graph minSpanningTree)
	{
		HashSet<Vertex> currentTree = new HashSet<Vertex>();
		currentTree.add(graph.vertices[0]);
		PriorityQueue<Edge> edgesToVisit = new PriorityQueue<Edge>();
		
		//Start at vertex 1.
		edgesToVisit.addAll(graph.vertices[0].edges);
		
		int weight = 0;
		Vertex src = null;
		Vertex dest = null;
		Edge curEdge = null;
		
		//Until all the edges in the graph as exhausted.
		while(!edgesToVisit.isEmpty())
		{
			curEdge = edgesToVisit.poll();
			src = curEdge.source;
			dest = curEdge.dest;
			
			//If the edge doesn't add a new node to the tree, discard it.
			if(currentTree.contains(dest))
				continue;
			else
			{
				weight+=curEdge.weight;
				if(src.vertexID < dest.vertexID)
					minSpanningTree.vertices[src.vertexID].edges.add(new Edge(src,dest,curEdge.weight));
				else
					minSpanningTree.vertices[dest.vertexID].edges.add(new Edge(dest,src,curEdge.weight));
				currentTree.add(dest);
				edgesToVisit.addAll(dest.edges);
			}
		}
		return weight;
	}
}
