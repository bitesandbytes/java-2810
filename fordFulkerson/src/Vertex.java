/*
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab
 * Vertex Class.
 */

import java.util.*;

public class Vertex 
{
	int vertexID;
	ArrayList<WeightedDirectedEdge> adjacentNodes;
	
	Vertex(int n)
	{
		vertexID = n;
		adjacentNodes = new ArrayList<WeightedDirectedEdge>();
	}
}
