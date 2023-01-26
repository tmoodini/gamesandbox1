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
	Sandbox2 sb2;
	
	public GameButtonListener(SpriteBatch batch, Texture img, GameButton button, Sandbox2 sb2) {
		this.sb2 = sb2;
		this.batch = batch;
		this.img = img;
		this.button = button;
		
		
	}
	
	@Override 
	public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        Gdx.app.log("my app", "Pressed"); //** Usually used to start Game, etc. **//
        GameButton b1 = (GameButton) event.getListenerActor();
        
        if(!b1.getSelected()) {
        	
        	b1.setText(sb2.getCurrentTurn());		
            batch.begin();
            batch.draw(img,0,0);
            batch.end();
            this.button.setSelected(true);
            if(sb2.getCurrentTurn() == "X") {
            	sb2.setCurrentTurn("O");
            }
            else {
            	sb2.setCurrentTurn("X");
            }
            b1.setDisabled(true);
        }
        
        
        return true;
}
	
	 public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
       Gdx.app.log("my app", "Released");
       TextButton b1 = (TextButton) event.getListenerActor();
       //b1.setText(sb2.getCurrentTurn());
       
       
       
}
}
