package com.mygdx.game;

public class GameBoard {
	
	int n = 3;
    State[][] board = new State[n][n];
    int moveCount;	
	
	public GameBoard() {
		for(int i = 0; i< 3; i++) {
			for(int j = 0; j < 3; j++) {
				board[i][j] = State.Blank;
			}
		}
		
	}
	
public State[][] getBoard() {
		return board;
	}

	public void setBoard(State[][] board) {
		this.board = board;
	}

public static enum State{Blank, X, O, Draw};
    
    
    
    public State move(int x, int y, State s){
    	
    	//System.out.println("Checking move");
        if(board[x][y] == null || board[x][y] == State.Blank){
            board[x][y] = s;
        }
        moveCount++;
        
        //check end conditions
        
        //check row
        for(int i = 0; i < n; i++){
            if(board[x][i] != s)
                break;
            if(i == n-1){
            	
            	System.out.println("Winner Row " + s);
                return s;
            }
        }
        
        //check column
        for(int i = 0; i < n; i++){
            if(board[i][y] != s)
                break;
            if(i == n-1){
            	System.out.println("Winner Column " + s);
                return s;
            }
        }
        
        //check diag
        if(x == y){
            //we're on a diagonal
            for(int i = 0; i < n; i++){
                if(board[i][i] != s)
                    break;
                if(i == n-1){
                	System.out.println("Winner Diag " + s);
                    return s;
                }
            }
        }
            
        //check anti diag (thanks rampion)
        if(x + y == n - 1){
            for(int i = 0; i < n; i++){
                if(board[i][(n-1)-i] != s)
                    break;
                if(i == n-1){
                	System.out.println("Winner AntiDiag " + s);
                    return s;
                }
            }
        }

        //check draw
        if(moveCount == (Math.pow(n, 2) - 1)){
            return State.Draw;
        }
        
        return State.Blank;
    }
	
    public State currentState(int x, int y) {
    	return board[x][y];
    }

}
