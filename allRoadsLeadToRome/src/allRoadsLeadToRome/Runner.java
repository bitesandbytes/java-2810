package allRoadsLeadToRome;
/*
 * Author : Sauce(CS13B056)
 * CS2810 -Advanced Programming Lab
 * All Roads Lead to Rome ?
 * Runner Class 
 */
import java.util.*;

public class Runner
{
	private static Vertex Rome = null;
	
	//Marks all nodes as unvisited.
	public static void markUnvisited(UndirectedGraph G)
	{
		int size = G.n;
		for(int i=0;i<size;i++)
			G.vertices[i].distance = Double.POSITIVE_INFINITY;
		
		return;
	}

	public static void main(String[] args)
	{
		UndirectedGraph Cities;
		int n;
		int e;
		Scanner in = new Scanner(System.in);
		n = in.nextInt();
		e = in.nextInt();
		Cities = new UndirectedGraph(n, e);
		int vertexA, vertexB;
		double weight;
				
		//Build the weighted graph.
		for(int i=0;i<e;i++)
		{
			vertexA = in.nextInt();
			vertexB = in.nextInt();
			weight = (double)in.nextInt();
			Cities.vertices[vertexA].edges.add(new WeightedEdge(Cities.vertices[vertexA], Cities.vertices[vertexB], weight));
			Cities.vertices[vertexB].edges.add(new WeightedEdge(Cities.vertices[vertexB], Cities.vertices[vertexA], weight));
		}
		
		//Query for a road between Rome and any given Vertex.
		int QueryVertex = 1;
		
		Runner.Rome = Cities.vertices[0];
		Runner.Rome.prev = null;
		
		
		while(QueryVertex!=0)
		{
			QueryVertex = in.nextInt();
			if(QueryVertex >= Cities.n)
			{
				System.out.println("Invalid Input.");
				continue;
			}
			Cities.vertices[QueryVertex].distance = 0.0;
			
			//Prints a path, if any
			if(PrimsAlgo.existsRoadBetween(Cities, QueryVertex))
				PrimsAlgo.printPathBetween(Cities, QueryVertex);
			else
				System.out.println("No route found.");
			
			//To process the next Query.
			markUnvisited(Cities);
		}
		in.close();
	}
}
