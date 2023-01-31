package com.mygdx.game.ai;

import com.mygdx.game.GameBoard;

public class GFG {
	static class Move
	{
	    int row, col;
	};
	

	
	private static GameBoard.State player = GameBoard.State.X;
	private static GameBoard.State	opponent = GameBoard.State.O;
	
	
	public GFG(GameBoard.State player) {
		if(player != GameBoard.State.X) {
			this.player = player;
			this.opponent = GameBoard.State.X;
		}
		
	}
	
	// This function returns true if there are moves
		// remaining on the board. It returns false if
		// there are no moves left to play.
	public static Boolean isMovesLeft(GameBoard.State board[][])
	{
	    for (int i = 0; i < 3; i++)
	        for (int j = 0; j < 3; j++)
	            if (board[i][j] == GameBoard.State.Blank)
	                return true;
	    return false;
	}
	 
	// This is the evaluation function as discussed
	// in the previous article ( http://goo.gl/sJgv68 )
	public static int evaluate(GameBoard.State board[][])
	{
	    // Checking for Rows for X or O victory.
	    for (int row = 0; row < 3; row++)
	    {
	        if (board[row][0] == board[row][1] &&
	            board[row][1] == board[row][2])
	        {
	            if (board[row][0] == player)
	                return +10;
	            else if (board[row][0] == opponent)
	                return -10;
	        }
	    }
	 
	    // Checking for Columns for X or O victory.
	    for (int col = 0; col < 3; col++)
	    {
	        if (board[0][col] == board[1][col] &&
	        		board[1][col] == board[2][col])
	        {
	            if (board[0][col] == player)
	                return +10;
	 
	            else if (board[0][col] == opponent)
	                return -10;
	        }
	    }
	 
	    // Checking for Diagonals for X or O victory.
	    if (board[0][0] == board[1][1] && board[1][1] == board[2][2])
	    {
	        if (board[0][0] == player)
	            return +10;
	        else if (board[0][0] == opponent)
	            return -10;
	    }
	 
	    if (board[0][2] == board[1][1] && board[1][1] == board[2][0])
	    {
	        if (board[0][2] == player)
	            return +10;
	        else if (board[0][2] == opponent)
	            return -10;
	    }
	 
	    // Else if none of them have won then return 0
	    return 0;
	}
	 
	// This is the minimax function. It considers all
	// the possible ways the game can go and returns
	// the value of the board
	public static int minimax(GameBoard.State board[][],
	                    int depth, Boolean isMax)
	{
	    int score = evaluate(board);
	 
	    // If Maximizer has won the game
	    // return his/her evaluated score
	    if (score == 10)
	        return score;
	 
	    // If Minimizer has won the game
	    // return his/her evaluated score
	    if (score == -10)
	        return score;
	 
	    // If there are no more moves and
	    // no winner then it is a tie
	    if (isMovesLeft(board) == false)
	        return 0;
	 
	    // If this maximizer's move
	    if (isMax)
	    {
	        int best = -1000;
	 
	        // Traverse all cells
	        for (int i = 0; i < 3; i++)
	        {
	            for (int j = 0; j < 3; j++)
	            {
	                // Check if cell is empty
	                if (board[i][j]== GameBoard.State.Blank)
	                {
	                    // Make the move
	                    board[i][j] = player;
	 
	                    // Call minimax recursively and choose
	                    // the maximum value
	                    best = Math.max(best, minimax(board,
	                                    depth + 1, !isMax));
	 
	                    // Undo the move
	                    board[i][j] = GameBoard.State.Blank;
	                }
	            }
	        }
	        return best;
	    }
	 
	    // If this minimizer's move
	    else
	    {
	        int best = 1000;
	 
	        // Traverse all cells
	        for (int i = 0; i < 3; i++)
	        {
	            for (int j = 0; j < 3; j++)
	            {
	                // Check if cell is empty
	                if (board[i][j] == GameBoard.State.Blank)
	                {
	                    // Make the move
	                    board[i][j] = opponent;
	 
	                    // Call minimax recursively and choose
	                    // the minimum value
	                    best = Math.min(best, minimax(board,
	                                    depth + 1, !isMax));
	 
	                    // Undo the move
	                    board[i][j] = GameBoard.State.Blank;
	                }
	            }
	        }
	        return best;
	    }
	}
	 
	// This will return the best possible
	// move for the player
	public static int[] findBestMove(GameBoard.State board[][])
	{
	    int bestVal = -1000;
	    int[] bestMove = new int[2];
	    bestMove[0] = -1;
	    bestMove[1] = -1;
	 
	    // Traverse all cells, evaluate minimax function
	    // for all empty cells. And return the cell
	    // with optimal value.
	    for (int i = 0; i < 3; i++)
	    {
	        for (int j = 0; j < 3; j++)
	        {
	            // Check if cell is empty
	            if (board[i][j] == GameBoard.State.Blank)
	            {
	                // Make the move
	                board[i][j] = player;
	 
	                // compute evaluation function for this
	                // move.
	                int moveVal = minimax(board, 0, false);
	 
	                // Undo the move
	                board[i][j] = GameBoard.State.Blank;
	 
	                // If the value of the current move is
	                // more than the best value, then update
	                // best/
	                if (moveVal > bestVal)
	                {
	                    bestMove[0] = i;
	                    bestMove[1] = j;
	                    bestVal = moveVal;
	                }
	            }
	        }
	    }
	 
	    System.out.printf("The value of the best Move " +
	                             "is : %d\n\n", bestVal);
	 
	    return bestMove;
	} 
	public static void main(String[] args) {
		GameBoard.State board[][] = {{ GameBoard.State.X, GameBoard.State.O, GameBoard.State.X },
                 { GameBoard.State.O, GameBoard.State.O, GameBoard.State.X },
                 { GameBoard.State.Blank, GameBoard.State.Blank, GameBoard.State.Blank }};

		 	int[] bestMove = findBestMove(board);

		 	System.out.printf("The Optimal Move is :\n");
		 	System.out.printf("ROW: %d COL: %d\n\n",
          bestMove[0], bestMove[1] );
	}

}
