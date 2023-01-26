package com.mygdx.game;

public class GameBoard {
	
	
	
	public GameBoard() {
		
	}
	
enum State{Blank, X, O, Draw};
    
    int n = 3;
    State[][] board = new State[n][n];
    int moveCount;
    
    public State move(int x, int y, State s){
    	
    	//System.out.println("Checking move");
        if(board[x][y] == null){
            board[x][y] = s;
        }
        moveCount++;
        
        //check end conditions
        
        //check col
        for(int i = 0; i < n; i++){
            if(board[x][i] != s)
                break;
            if(i == n-1){
            	System.out.println("Winner! " + s );
                return s;
            }
        }
        
        //check row
        for(int i = 0; i < n; i++){
            if(board[i][y] != s)
                break;
            if(i == n-1){
            	System.out.println("Winner! " + s );
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
                	System.out.println("Winner! " + s );
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
	public static void main(String[] args) {
		
	}

}
