package allRoadsLeadToRome;
/*
 * Author : Sauce(CS13B056)
 * CS2810 -Advanced Programming Lab
 * All Roads Lead to Rome ?
 * Weighted Edge Class 
 */
public class WeightedEdge
{
	public Vertex A, B;
	public double weight;
	public WeightedEdge(Vertex A, Vertex B, double weight)
	{
		this.A =  A;
		this.B = B;
		this.weight = weight;
	}
	public Vertex getDest()
	{
		return B;
	}
	public Vertex getSrc()
	{
		return A;
	}
	public double getWeight()
	{
		return weight;
	}
}
