package com.mygdx.game.ai;

import com.mygdx.game.GameBoard;

public class EasyAI implements TicTacAI{
	private static GameBoard.State player = GameBoard.State.X;
	private static GameBoard.State	opponent = GameBoard.State.O;
	
	
	public EasyAI(GameBoard.State player) {
		if(player != GameBoard.State.X) {
			this.player = player;
			this.opponent = GameBoard.State.X;
		}
	}
	
	public int[] findBestMove(GameBoard.State[][] board){
		int row = -1;
		int col = -1;
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j <3; j++) {
				if(board[i][j] == GameBoard.State.Blank) {
					return new int[] {i,j};
				}
			}
		}
		return new int[] {row,col};
	}
}
