package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.mygdx.game.GameBoard.State;
import com.mygdx.game.ai.EasyAI;
import com.mygdx.game.ai.GFG;
import com.mygdx.game.ai.TicTacAI;

public class GameController {
	
	private MainGame mgui;
	private GameBoard board;
	private GameBoard.State currentPlayer;
	enum MoveResult{WIN,DRAW,ACCEPTED,OCCUPIED};
	//private GFG aiPlayer; 
	private EasyAI easyAI;
	private TicTacAI aiPlayer;
	private TTTScreen[] screen;
	private MainMenuScreen mainMenuScreen;
	
	public GameController() {
		
		this.mgui = new MainGame(this);
		this.board = new GameBoard();
		this.currentPlayer = GameBoard.State.X;
		this.aiPlayer = new GFG(currentPlayer);
		
		
		
	}
	
	
	public MoveResult move(int x, int y){
		System.out.println("Moving = " + currentPlayer.toString());
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
			mgui.setWinLabelText("WINNER!");
			return MoveResult.WIN;
		}
		
		
		return MoveResult.DRAW;
	}
	
	public void flipCurrentPlayer() {
		
		if(this.currentPlayer == GameBoard.State.X ) {
			this.currentPlayer = GameBoard.State.O;
		}
		else if(this.currentPlayer == GameBoard.State.O ) {
			this.currentPlayer = GameBoard.State.X;
		}
	}
	
	public void aiMove() {
		GameBoard.State aiPlay = currentPlayer;
		System.out.println("AI " + currentPlayer.toString());
		int[] aiMove = aiPlayer.findBestMove(this.board.getBoard());
		System.out.println(aiMove[0]);
		if(aiMove[0] >= 0) {
			MoveResult mr = this.move(aiMove[0],aiMove[1]);
			if(mr == mr.ACCEPTED || mr == mr.WIN) {
				
			    mgui.flipButton(aiMove[0], aiMove[1], aiPlay);
			    System.out.println("AI " + aiPlay.toString() + " Wants row: " + aiMove[0] + " Col: " + aiMove[1]);
			    //this.flipCurrentPlayer();
			}
		}
		
	}
	
	public void newGame() {
		
		this.board = new GameBoard();
		this.mgui.newGame();
		
	}
	

	public MainGame getMgui() {
		return mgui;
	}

	public void setMgui(MainGame mgui) {
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
