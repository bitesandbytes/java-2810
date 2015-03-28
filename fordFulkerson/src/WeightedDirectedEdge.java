/*
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab
 * Weighted Directed Edge Class.
 */
 
public class WeightedDirectedEdge implements Comparable<WeightedDirectedEdge>
{
	Vertex source, dest;
	int flowCapacity;
	
	public WeightedDirectedEdge(Vertex source, Vertex dest, int weight) 
	{
		this.source = source;
		this.dest = dest;
		this.flowCapacity = weight;		
	}
	public int compareTo(WeightedDirectedEdge other)
	{
		return (new Integer(this.flowCapacity)).compareTo(new Integer(other.flowCapacity));
	}
}
