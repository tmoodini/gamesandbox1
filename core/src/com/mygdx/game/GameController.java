package com.mygdx.game;

import com.mygdx.game.GameBoard.State;

public class GameController {
	
	private MainGameUI mgui;
	private GameBoard board;
	private GameBoard.State currentPlayer;
	enum MoveResult{WIN,DRAW,ACCEPTED,OCCUPIED};
	
	public GameController() {
		this.mgui = new MainGameUI(this);
		this.board = new GameBoard();
		this.currentPlayer = GameBoard.State.X;
	}
	
	
	public MoveResult move(int x, int y){
		
		GameBoard.State stateOfSquare = board.currentState(x, y);
		if(stateOfSquare == GameBoard.State.X || stateOfSquare == GameBoard.State.O) {
			return MoveResult.OCCUPIED;
		}
		stateOfSquare = board.move(x, y, this.currentPlayer);
		
		if(stateOfSquare == GameBoard.State.Blank) {
			this.flipCurrentPlayer();
			return MoveResult.ACCEPTED;
		}
		
		
		if(stateOfSquare == GameBoard.State.X || stateOfSquare == GameBoard.State.O)
		{
			return MoveResult.WIN;
		}
		
		
		return MoveResult.DRAW;
	}
	
	public void flipCurrentPlayer() {
		System.out.println("FLIPPING");
		if(this.currentPlayer == GameBoard.State.X ) {
			this.currentPlayer = GameBoard.State.O;
		}
		else if(this.currentPlayer == GameBoard.State.O ) {
			this.currentPlayer = GameBoard.State.X;
		}
	}
	
	public void newGame() {
		
		this.board = new GameBoard();
		this.mgui.newGame();
		
	}
	

	public MainGameUI getMgui() {
		return mgui;
	}

	public void setMgui(MainGameUI mgui) {
		this.mgui = mgui;
	}

	public GameBoard getBoard() {
		return board;
	}

	public void setBoard(GameBoard board) {
		this.board = board;
	}


	public GameBoard.State getCurrentPlayer() {
		return currentPlayer;
	}


	public void setCurrentPlayer(GameBoard.State currentPlayer) {
		this.currentPlayer = currentPlayer;
	}

}
