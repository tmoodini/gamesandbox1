package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class ResetButtonListener extends InputListener{
	
	private GameBoard gb;
	private Sandbox2 sb2;
	private SpriteBatch batch;
	private Texture img;
	ResetButtonListener(SpriteBatch batch, Texture img,GameBoard gb, Sandbox2 sb2){
		this.gb = gb;
		this.sb2 = sb2;
		this.batch = batch;
		this.img = img;
		
	}
	
	public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
        //Gdx.app.log("my app", "Pressed"); //** Usually used to start Game, etc. **//
        TextButton reset = (TextButton) event.getListenerActor();
        System.out.println("RESET!");
        sb2.newGame(gb);
        batch.begin();
        batch.draw(img,0,0);
        batch.end();
        return true;
 }

}
