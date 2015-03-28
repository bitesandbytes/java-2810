package isAcyclic;
/*
 * Author : Sauce(CS13B056)
 * CS2810 -Advanced Programming Lab
 * Testing reliability of a network.
 * Vertex Class 
 */
import java.util.*;
public class Vertex 
{
	public boolean isVisited;
	public List<Vertex> neighbours;
	
	public Vertex()
	{
		isVisited = false;
		neighbours = new ArrayList<Vertex>();
	}
}
