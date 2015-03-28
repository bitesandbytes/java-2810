/*
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab
 * Runner Class for implementing Ford-Fulkerson Algorithm
 */

import java.util.*;

public class Runner 
{
	//Maintains the current Path using a stack of edges.
	private static Stack<WeightedDirectedEdge> curPath;
	private static WeightedDirectedEdge bottleneckPipe;	
	public static void main(String[] args)
	{
		int n,m;
		Scanner in = new Scanner(System.in);
		curPath = new Stack<WeightedDirectedEdge>();
		bottleneckPipe = null;
		n= in.nextInt();
		Graph graph = new Graph(n);
		m = in.nextInt();
		int sourceID, destID;
		int flowCapacity;
		WeightedDirectedEdge e;
		for(int i=0;i<m;i++)
		{
			sourceID = in.nextInt();
			destID = in.nextInt();
			flowCapacity = in.nextInt();
			e = new WeightedDirectedEdge(graph.vertices[sourceID],graph.vertices[destID],flowCapacity);
			graph.vertices[sourceID].adjacentNodes.add(e);
		}
		in.close();
		boolean flowSubOptimal = findPath(graph.vertices[0], graph.vertices[n-1]);;
		int maxFlow = 0;
		while(flowSubOptimal)
		{			
			maxFlow += bottleneckPipe.flowCapacity;
			useAugmentingPath();
			flowSubOptimal = findPath(graph.vertices[0], graph.vertices[n-1]);
		}
		System.out.println(maxFlow);
		curPath.clear();
	}
	
	//Finds a path between source and dest.
	public static boolean findPath(Vertex source, Vertex dest)
	{
		if(source.vertexID == dest.vertexID)
			return true;
		
		Vertex destVertex = null;
		for(WeightedDirectedEdge curEdge : source.adjacentNodes)
		{
			destVertex = curEdge.dest;
			curPath.push(curEdge);
			if(findPath(destVertex,dest))
			{
				if(bottleneckPipe == null)
					bottleneckPipe = curEdge;
					
				if(curEdge.compareTo(bottleneckPipe) < 0)
					bottleneckPipe = curEdge;
				
				return true;
			}
			curPath.pop();
		}
		return false;		
	}
	
	//Uses the path that's stored in curPath and makes a flow.
	public static void useAugmentingPath()
	{
		//Removes the edge that was bottleneck for the last iteration.
		bottleneckPipe.source.adjacentNodes.remove(bottleneckPipe);
		WeightedDirectedEdge curEdge = curPath.pop();
		while(!curPath.isEmpty())
		{
			curEdge = curPath.pop();
			curEdge.flowCapacity -= bottleneckPipe.flowCapacity;
			if(curEdge.flowCapacity == 0)
				curEdge.source.adjacentNodes.remove(curEdge);
		}
		curPath.clear();
		bottleneckPipe = null;
		return;
	}
}
