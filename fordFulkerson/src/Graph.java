/*
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab
 * Graph Class.
 */

public class Graph 
{
	Vertex[] vertices;
	int size;
	
	Graph(int n)
	{
		this.size = n;
		vertices = new Vertex[n];
		for(int i=0;i<n;i++)
			vertices[i] = new Vertex(i);
	}
}
