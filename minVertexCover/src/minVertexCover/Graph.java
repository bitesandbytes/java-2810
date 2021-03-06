/*
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab
 * Graph Class Declaration.
 */
package minVertexCover;

public class Graph
{
	public Vertex[] vertices;
	public int n;
	Graph(int n)
	{
		vertices = new Vertex[n];
		for(int i = 0;i<n;i++)
			vertices[i] = new Vertex(i);
		this.n = n;
	}
}
