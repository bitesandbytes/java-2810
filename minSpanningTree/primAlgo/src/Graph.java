/*
 * Author : Sauce(CS13B056)
 * CS2810 -Advanced Programming Lab
 * Metro Rail Network Planning
 * Graph Class 
 */

public class Graph 
{
	Vertex vertices[];
	int n, e;
	public Graph(int n, int e)
	{
		this.n = n;
		this.e = e;
		vertices = new Vertex[n];
		for(int i=0;i<n;i++)
			vertices[i] = new Vertex(i);
	}
}
