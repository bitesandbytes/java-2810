/*Wordament Implementation
 * Filename: board.java
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab
 */

package wordament;

public class board 
{
	private int m,n;
	public cell[][] grid;
	
	public board()
	{
		m = 0;
		n = 0;
		grid = null;
		return;
	}
	
	public board(int m, int n)
	{
		this.m = m;
		this.n = n;
		grid = new cell[m][n];
	}
	
	public void printBoard()
	{
		for(int i=0;i<this.m;i++)
		{
			System.out.println("\n");
			for(int j=0;j<this.n;j++)
				System.out.print(grid[i][j].letter + " ");
		}
		return;
	}
	
	private boolean backtracker(String word, int start, int end, int r, int c,int pos)
	{
		//If the search crosses the boundaries of the board.
		if(r >= this.m || c >= this.n || r <= -1 || c <= -1)
			return false;
		
		if(start == pos && pos == word.length()-1)
		{
			System.out.println("YES");
			return true;
		}
		
		//If the search reaches a marked cell
		if(grid[r][c].isUsed())
			return false;
		
		//If the search doesn't match the starting of the word.
		if(!(word.substring(start, end).equals(grid[r][c].letter)))
			return false;
		
		//Mark the current letter as used. Implement backtracking.
		grid[r][c].markUsed();
		
		//Declare boolean results.
		boolean found = false;
		
		//Move right.
		found = backtracker(word,start+1,end+1,r,c+1,pos+1);
		if(found == true)
		{
			grid[r][c].markUnused();
			return true;
		}
				
		//Move down.
		found = backtracker(word,start+1,end+1,r+1,c,pos+1);
		if(found == true)
		{
			grid[r][c].markUnused();
			return true;
		}
		
		//Move up.
		found = backtracker(word,start+1,end+1,r-1,c,pos+1);
		if(found == true)
		{
			grid[r][c].markUnused();
			return true;
		}
		
		//Move left.
		found = backtracker(word,start+1,end+1,r,c-1,pos+1);
		if(found == true)
		{
			grid[r][c].markUnused();
			return true;
		}
		
		//Mark the current letter as unused if backtracking fails.
		grid[r][c].markUnused();
		return false;
	}
	
	public void check(String word)
	{
		boolean wordFound = false;
		for(int i=0;i<this.m;i++)
		{
			for(int j=0;j<this.n;j++)
			{
				if(word.substring(0, 1).equals(grid[i][j].letter))
				{
					wordFound = backtracker(word,0,1,i,j,0);
					if(wordFound == true)
						break;
				}
			}
			if(wordFound == true)
				break;
		}
		if(!wordFound)
			System.out.println("NO");
		return ;
	}
}
