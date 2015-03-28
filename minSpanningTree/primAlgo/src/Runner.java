import java.io.*;
import java.util.*;
/*
 * Author : Sauce(CS13B056)
 * CS2810 -Advanced Programming Lab
 * Metro Rail Network Planning
 * Runner Class 
 */

public class Runner 
{
	public static void main(String[] args) throws FileNotFoundException
	{
		//For Prim's algorithm.
		PrintStream out = new PrintStream(new FileOutputStream(args[1]));
		System.setOut(out);
		
		Graph graph;
		Graph minSpanningTreePrimAlgo,minSpanningTreeKruskalAlgo;		
		int cost;
		String inputFile = args[0];
		Scanner in = new Scanner(new File(inputFile));	
		cost = in.nextInt();
		int max = 0;
		int vertexA, vertexB, weight;
		ArrayList<Integer> input = new ArrayList<Integer>();
		PriorityQueue<Edge> edges = new PriorityQueue<Edge>();
		//Scan the input and put the input into a list.
		while(in.hasNext())
		{
			vertexA = in.nextInt();
			vertexB = in.nextInt();
			weight = in.nextInt();
			if(vertexA > max)
			{
				max = vertexA;
			}
			if(vertexB > max)
			{
				max = vertexB;
			}
			input.add(vertexA-1);
			input.add(vertexB-1);
			input.add(weight);
		}
		in.close();
		
		//Create the graphs.
		graph = new Graph(max,0);
		minSpanningTreePrimAlgo = new Graph(max, 0);
		minSpanningTreeKruskalAlgo = new Graph(max, 0);
		
		Iterator<Integer> inputValue = input.iterator();
		
		//Build the graph.
		while(inputValue.hasNext())
		{
			vertexA = inputValue.next();
			vertexB = inputValue.next();
			weight = inputValue.next();
			if(vertexA < vertexB)
				edges.add(new Edge(graph.vertices[vertexA], graph.vertices[vertexB], weight));
			else
				edges.add(new Edge(graph.vertices[vertexB], graph.vertices[vertexA], weight));
			graph.vertices[vertexA].edges.add(new Edge(graph.vertices[vertexA], graph.vertices[vertexB], weight));
			graph.vertices[vertexB].edges.add(new Edge(graph.vertices[vertexB], graph.vertices[vertexA], weight));
		}
		
		//Run the Prim's Algorithm and print the necessary details.
		System.out.println("(Using Prim's algorithm with 1 as the starting node)");
		weight = PrimAlgo.buildMinSpanningTree(graph,minSpanningTreePrimAlgo);
		System.out.println(weight*cost);
		printMinSpanningTree(minSpanningTreePrimAlgo);
		out.close();
		
		out = new PrintStream(new FileOutputStream(args[2]));
		System.setOut(out);
		
		//Run the Kruskal's Algorithm and print the necessary details.
		System.out.println("(Using Kruskal's algorithm)");
		weight = KruskalAlgo.buildMinSpanningTree(graph, edges, minSpanningTreeKruskalAlgo);
		System.out.println(weight*cost);
		printMinSpanningTree(minSpanningTreeKruskalAlgo);	
	}

	private static void printMinSpanningTree(Graph minSpanningTree) 
	{
		Vertex curVertex;
		Iterator<Edge> edge;
		Edge curEdge;
		for(int i=0;i<minSpanningTree.n;i++)
		{
			curVertex = minSpanningTree.vertices[i];
			edge = curVertex.edges.iterator();
			while(edge.hasNext())
			{
				curEdge = edge.next();
				System.out.println((curEdge.source.vertexID+1)+" "+(curEdge.dest.vertexID+1));
			}
		}
	}
}
