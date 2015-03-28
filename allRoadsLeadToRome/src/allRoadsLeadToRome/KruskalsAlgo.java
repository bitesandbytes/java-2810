package allRoadsLeadToRome;

import java.util.*;

public class KruskalsAlgo
{
	public static UndirectedGraph G = null;
	public static ArrayList<WeightedEdge> sortedEdgeList = null;
	
	//Builds the empty graph G and a sorted edge list.
	public static void initGraph(UndirectedGraph Cities)
	{
		G = new UndirectedGraph(Cities.n, 0);
		
		//Build the edge list.
		for(Vertex v : Cities.vertices)
		{
			for(WeightedEdge e: v.edges)
			{
				//If already a copy of the edge exists, don't add it.
				if(sortedEdgeList.contains(new WeightedEdge(e.getDest(), e.getSrc(), e.getWeight())))
					continue;
				else
				{
					System.out.println("Adding ("+e.getSrc()+","+e.getDest()+","+e.getWeight());
					sortedEdgeList.add(e);
				}
			}
		}
		Collections.sort(sortedEdgeList);
	}
	
	//TODO: Implement Kruskal's algorithm here.
}
