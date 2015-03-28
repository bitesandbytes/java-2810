package isAcyclic;
/*
 * Author : Sauce(CS13B056)
 * CS2810 -Advanced Programming Lab
 * Testing reliability of a network.
 * Graph Class 
 */

public class Graph 
{
	public Vertex[] vertices;
	int n;
	int e;
	
	public Graph(int n, int e)
	{
		vertices = new Vertex[n];
		for(int i=0;i<n;i++)
			vertices[i] = new Vertex();
		this.n = n;
		this.e = e;
	}
}
