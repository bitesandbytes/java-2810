package allRoadsLeadToRome;
/*
 * Author : Sauce(CS13B056)
 * CS2810 -Advanced Programming Lab
 * All Roads Lead to Rome ?
 * Vertex Class 
 */
import java.util.*;

public class Vertex implements Comparable<Vertex>
{
	public double distance;
	Vertex prev;
	int vertexID;
	public List<WeightedEdge> edges;
	
	Vertex()
	{
		distance = Double.POSITIVE_INFINITY;
		edges = new ArrayList<WeightedEdge>();
		prev = null;
	}
	
	public int compareTo(Vertex v)
	{
		if(this.distance < v.distance)
			return -1;
		else if(this.distance > v.distance)
			return 1;
		else
			return 0;
	}
}
