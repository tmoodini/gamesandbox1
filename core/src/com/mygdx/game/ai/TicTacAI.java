package com.mygdx.game.ai;

import com.mygdx.game.GameBoard;

public interface TicTacAI {
	public int[] findBestMove(GameBoard.State board[][]);
}
