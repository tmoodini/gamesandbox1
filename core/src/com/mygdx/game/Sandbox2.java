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

public class Sandbox2 extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	Skin skin;
	TextButton b1;
	Stage stage;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		
		skin = new Skin(Gdx.files.internal("glassy/glassy-ui.json"));
		
		b1 = new TextButton("B1",skin);
		 stage = new Stage(new ScreenViewport());
		b1.setSize(100, 100);
        //b1.setOrigin(-50, -50);
        b1.setPosition(-50, 0);
        b1.setX(stage.getViewport().getScreenWidth()/2);
        b1.setY(stage.getViewport().getScreenHeight()/2);
        
      b1.addListener(new GameButtonListener(batch,img));
       

       
        stage.act();
		 stage.addActor(b1);
	}

	@Override
	public void render () {
		ScreenUtils.clear(0, 0, 0, 0);
		
	     
        
        Gdx.input.setInputProcessor(stage);
        
        
       
		//batch.draw(img, 0, 0);
		 
		    stage.draw();
		    
		batch.begin();    
		//b1.draw(batch, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
