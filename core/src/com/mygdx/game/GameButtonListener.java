package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class GameButtonListener extends InputListener{
	
	
	SpriteBatch batch;
	Texture img;
	GameButton button;
	GameScreen gameScreen;
	
	GameController controller;
	
	public GameButtonListener(SpriteBatch batch, Texture img, MainGame game) {
		this.controller = game.getController();
		this.batch = batch;
		this.img = img;
		this.gameScreen = game.getGameScreen();
		
		
	}
	
	@Override 
	public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
       
        GameButton b1 = (GameButton) event.getListenerActor();
        
        if(!b1.getSelected()) {
        	GameBoard.State currentPlayer = controller.getCurrentPlayer();
        	GameController.MoveResult moveResult = controller.move(b1.getRow(), b1.getColumn());
        	
        	if(moveResult != GameController.MoveResult.OCCUPIED ) {	
        			b1.setText(currentPlayer.toString());		
        	}
        	
        	if(moveResult == GameController.MoveResult.DRAW || moveResult == GameController.MoveResult.WIN) {
        		//controller.gameOver();
        	}

        	controller.aiMove();     
            b1.setSelected(true);
            b1.setDisabled(true);
 
        }
        
        
        return true;
}
	
	 public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
       
       TextButton b1 = (TextButton) event.getListenerActor();
   
	 }

}
