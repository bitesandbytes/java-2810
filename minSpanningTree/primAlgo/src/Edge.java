/*
 * Author : Sauce(CS13B056)
 * CS2810 -Advanced Programming Lab
 * Metro Rail Network Planning
 * Edge Class 
 */

public class Edge implements Comparable<Edge>
{
	public Vertex source, dest;
	public int weight;
	
	public Edge(Vertex src, Vertex dest, int wght)
	{
		this.source = src;
		this.dest = dest;
		this.weight = wght;
	}
	
	public int compareTo(Edge e)
	{
		if(this.weight < e.weight)
			return -1;
		else if(this.weight == e.weight)
			return 0;
		else
			return 1;
	}
}
