package iitm.apl.KnightsTour;

import java.util.*;

/*
 * Implementing Warnsdorf's heuristic to solve the knight's tour problem.
 */
public class findTour extends ChessBoard
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public static void main(String[] args)
	{
		initialise(new findTour());
	}

	@Override
	List<Move> tour(Move m)
	{
		List<Move> movesList = new ArrayList<Move>();
		Stack<Move> moveSet = new Stack<Move>();
		Move[] reachables = m.reachableMoves();
		Move curPosition = m;
		Move minMove = (reachables != null ? reachables[0] : null);
		while (minMove != null)
		{
			getMinMove(reachables);
			minMove = reachables[0];
			makeMove(minMove);
			moveSet.push(minMove);
			curPosition = minMove;
		}
		return null;
	}

	// Returns the move that results in min number of moves next.
	void getMinMove(Move[] possibleStartPoints)
	{
		Arrays.sort(possibleStartPoints);
		return;
	}
}
