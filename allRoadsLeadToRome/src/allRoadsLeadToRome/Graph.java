package allRoadsLeadToRome;
/*
 * Author : Sauce(CS13B056)
 * CS2810 -Advanced Programming Lab
 * All Roads Lead to Rome ?
 * Graph Class 
 */
public class Graph
{
	public Vertex[] vertices;
	public int n, e;
	
	Graph(int n, int e)
	{
		this.n = n;
		vertices = new Vertex[n];
		this.e = e;
		for(int i=0;i<n;i++)
		{
			vertices[i] = new Vertex();
			vertices[i].vertexID = i;
		}
	}
}
