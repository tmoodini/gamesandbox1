package com.mygdx.game;

import com.badlogic.gdx.Screen;

public interface TTTScreen extends Screen{
	
	public void flipButton(int row, int column, GameBoard.State state);

}
