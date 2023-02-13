package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener;
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener.ChangeEvent;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class MainMenuScreen implements Screen{
	
	private MainGame game;
	private TextButton startButton;
	private Skin skin;
	private Stage stage;
	
	private Table table;
	private TextButton easyGameButton;
	private TextButton hardGameButton;
	
	
	public MainMenuScreen(final MainGame game) {
		this.game = game;
		skin = new Skin(Gdx.files.internal("glassy/glassy-ui.json"));
		
		stage = new Stage(new FitViewport(800, 800));
		//startButton = new GameButton("START",skin);
		easyGameButton = new TextButton("Easy Game",skin);
		hardGameButton = new TextButton("Hard Game",skin);
		
		/**
		startButton.addListener(new InputListener() {
	        
	        @Override 
	    	public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
	           
	          // TextButton b1 = (TextButton) event.getListenerActor();
	           game.changeToGameScreen();
	            
	            return true;
	        }
	    });**/
		
		easyGameButton.addListener(new InputListener() {
	        
	        @Override 
	    	public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
	           
	          game.getController().setAI("EASY");
	          game.getController().newGame();
	           game.changeToGameScreen();
	            
	            return true;
	        }
	    });
		
		hardGameButton.addListener(new InputListener() {
	        
	        @Override 
	    	public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
	           
	          game.getController().setAI("HARD");
	          game.getController().newGame();
	           game.changeToGameScreen();
	            
	            return true;
	        }
	    });
		table = new Table();
		table.setX(stage.getViewport().getScreenWidth()/2);
		table.setY(stage.getViewport().getScreenWidth()/2);
		//table.add(startButton);
		//table.row();
		table.add(easyGameButton);
		table.row();
		table.add(hardGameButton);
		stage.addActor(table);
		stage.act();
		Gdx.input.setInputProcessor(stage);
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(1, 1, 1, 1);
		
		Gdx.input.setInputProcessor(stage);
		stage.draw();
		stage.act();
		
		
	}

	@Override
	public void resize(int width, int height) {
		 stage.getViewport().update(width, height, true);
		
	}

	@Override
	public void pause() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void resume() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void hide() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void dispose() {
		stage.dispose();
		
	}

}
