/*Wordament Implementation
 * Filename: wordament.java
 * Author : Sauce (CS13B056)
 * CS2810 - Advanced Programming Lab
 */

package wordament;

import java.util.Scanner;

public class wordament 
{
	public static void main(String[] args)
	{
		board B;
		Scanner input = new Scanner (System.in);
		int m = input.nextInt();
		int n = input.nextInt();
		input.nextLine();
		B = new board(m,n);
		
		String line;
		String[] chars;
		int i,j;
		B.grid = new cell[m][n];
		for(i = 0;i < m;i++)
		{
			line = input.nextLine();
			chars = line.split(" ");
			for(j = 0;j < n;j++)
			{
				B.grid[i][j] = new cell(chars[j]);
			}
		}	
		
		String word = input.next();
		while(!(word.equals("EXIT")))
		{
			B.check(word);
			word = input.next();
		}
		input.close();
	}
}
