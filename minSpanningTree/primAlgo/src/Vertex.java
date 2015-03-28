import java.util.*;
/*
 * Author : Sauce(CS13B056)
 * CS2810 -Advanced Programming Lab
 * Metro Rail Network Planning
 * Vertex Class 
 */

public class Vertex 
{
	public int vertexID;
	public ArrayList<Edge> edges;
	Vertex(int ID)
	{
		this.vertexID = ID;
		this.edges = new ArrayList<Edge>();
	}
}
	