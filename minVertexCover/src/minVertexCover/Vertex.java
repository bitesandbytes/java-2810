/*
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab
 * Vertex Class Declaration.
 */
package minVertexCover;
import java.util.*;

public class Vertex implements Comparable<Vertex>
{
	public boolean isIncluded;
	public int minVertexSizeStartingHere;
	public int degree;
	public int vertexID ;
	public ArrayList<Vertex> adjacentVertices;
	Vertex(int n)
	{
		isIncluded = false;
		minVertexSizeStartingHere = 0;
		vertexID = n;
		adjacentVertices = new ArrayList<Vertex>();
	}
	public int compareTo(Vertex other)
	{
		return (new Integer(this.degree)).compareTo(new Integer(other.degree));
	}
}
