/*Wordament Implementation
 * Filename: cell.java
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab
 */

package wordament;

public class cell 
{
	public String letter;
	private boolean used;
	
	public cell()
	{
		letter = "A";
		used = false;
		return;
	}
	
	public cell(String letter)
	{
		this.letter = letter;
		this.used = false;
		return;
	}
	
	public cell(cell other)
	{
		this.letter = other.letter;
		this.used = other.used;
		return;
	}
	
	public void markUsed()
	{
		this.used = true;
		return;
	}
	
	public void markUnused()
	{
		this.used = false;
		return;
	}
	
	public boolean isUsed()
	{
		return used;
	}
}
