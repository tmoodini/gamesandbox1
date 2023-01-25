package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Sandbox2 extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Skin skin;
	GameButton b1;
	Stage stage;
	Viewport viewport;
	String currentTurn;
	
	@Override
	public void create () {
		
		currentTurn ="X";
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		
		skin = new Skin(Gdx.files.internal("glassy/glassy-ui.json"));
		
		
		viewport = new ScreenViewport();
		b1 = new GameButton("",skin);
		 stage = new Stage(viewport);
		 //Gdx.gl.glViewport(0, 0, Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
		b1.setSize(100, 100);
        //b1.setOrigin(-50, -50);
        b1.setPosition(-50, 0);
        b1.setX(stage.getViewport().getScreenWidth()/2);
        b1.setY(stage.getViewport().getScreenHeight()/2);
        
      b1.addListener(new GameButtonListener(batch,img, b1, this));
       

       
        stage.act();
		 stage.addActor(b1);
		 //Gdx.gl.glClearColor(1f, 1f, 1f, 1f);
	}

	@Override
	public void render () {
		ScreenUtils.clear(1, 1, 1, 1);
		
	     
        
        Gdx.input.setInputProcessor(stage);
        
        
       
		//batch.draw(img, 0, 0);
		 stage.getViewport().update(stage.getViewport().getScreenWidth(), stage.getViewport().getScreenHeight());
		    stage.draw();
		    stage.act();
		batch.begin();    
		//b1.draw(batch, 0);
		batch.end();
	}
	
	@Override
	public void resize(int width, int height) {
		
		viewport.update(width, height);
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
	
	public String getCurrentTurn() {
		
		return this.currentTurn;
	}
	
	
}
