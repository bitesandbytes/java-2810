public class TicTacToeBoard
{
	int[][] grid;

	public TicTacToeBoard()
	{
		grid = new int[3][3];
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				grid[i][j] = -1;
	}

	//Sets 'val' in grid[x][y] if it's empty.
	public boolean set(int x, int y, int val)
	{
		if (grid[x][y] != -1)
			return false;
		else
		{
			grid[x][y] = val;
			return true;
		}
	}

	// Returns 'true' if the board is full or there is a winner.
	public boolean isComplete()
	{
		if (whoWon() == -2)
			return false;
		else
			return true;
	}

	// Returns ID of the winner.
	public int whoWon()
	{
		// If one of the players won.
		if (winRow() >= 0 || winCol() >= 0 || winDiag() >= 0)
			return max(winRow(), max(winCol(), winDiag()));

		// If it's a draw.
		else if (isDraw())
			return -1;

		// If game is still in progress and no one has won yet.
		else
			return -2;
	}

	// Returns true if the match is a draw.
	private boolean isDraw()
	{
		// Check if the grid is filled.
		for (int i = 0; i < 3; i++)
			for (int j = 0; j < 3; j++)
				if (grid[i][j] == -1)
					return false;

		if (winRow() == -1 && winCol() == -1 && winDiag() == -1)
			return true;
		else
			return false;
	}

	// Returns ID of the winner, if any, in the diagonal.
	private int winDiag()
	{
		if (grid[0][0] == grid[1][1] && grid[1][1] == grid[2][2]
				&& grid[0][0] != -1)
			return grid[0][0];
		else if (grid[0][2] == grid[1][1] && grid[1][1] == grid[2][0]
				&& grid[1][1] != -1)
			return grid[1][1];
		else
			return -1;
	}

	// Returns ID of the winner, if any, in any column.
	private int winCol()
	{
		int col = 0;
		boolean found = true;
		int prev = grid[0][0];
		for (col = 0; col < 3; col++)
		{
			found = true;
			prev = grid[0][col];
			for (int row = 0; row < 3; row++)
				if (grid[row][col] != prev)
					found = false;
			if (found)
				if (grid[0][col] != -1)
					return grid[0][col];
		}
		return -1;
	}

	// Retuns max of 'a' and 'b'.
	private int max(int a, int b)
	{
		return (a > b ? a : b);
	}

	// Returns ID of the winner, if any, in any column.
	private int winRow()
	{
		int row = 0;
		boolean found = true;
		int prev = grid[0][0];
		for (row = 0; row < 3; row++)
		{
			found = true;
			prev = grid[row][0];
			for (int col = 0; col < 3; col++)
				if (grid[row][col] != prev)
					found = false;
			if (found)
				if (grid[row][0] != -1)
					return grid[row][0];
		}
		return -1;
	}
}
