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
	
	public GameButtonListener(SpriteBatch batch, Texture img) {
		
		this.batch = batch;
		this.img = img;
		
		
	}
	
	@Override 
	public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        Gdx.app.log("my app", "Pressed"); //** Usually used to start Game, etc. **//
        TextButton b1 = (TextButton) event.getListenerActor();
        b1.setText("Pressed");		
        batch.begin();
        batch.draw(img,0,0);
        batch.end();
        
        return true;
}
	
	 public void touchUp (InputEvent event, float x, float y, int pointer, int button) {
       Gdx.app.log("my app", "Released");
       TextButton b1 = (TextButton) event.getListenerActor();
       b1.setText("Pressed");
       b1.setText("B1");
       
       
}
}
