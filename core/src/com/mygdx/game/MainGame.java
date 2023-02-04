package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class MainGame extends Game {
	SpriteBatch batch;
	Texture img;
	Skin skin;
	GameButton b1;
	GameButton b2;
	Stage stage;
	Viewport viewport;
	String currentTurn;
	GameButton[][] buttons;
	GameBoard gb;
	TextButton resetButton;
	Label winLabel;
	BitmapFont font;
	private GameController controller;
	private Camera camera;
	
	public MainGame(GameController controller) {
		
		this.controller = controller;
		
	}
	
	@Override
	public void create () {
		
		this.setScreen(new MainMenuScreen(this));
		
		
		/**
		viewport = new FitViewport(800, 800);
		//viewport.update(800,800);
		stage = new Stage(viewport);
		skin = new Skin(Gdx.files.internal("glassy/glassy-ui.json"));
		resetButton = new GameButton("RESET",skin);
		currentTurn ="X";
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		
		buttons = new GameButton[3][3];
		resetButton.addListener(new ResetButtonListener(batch, img,controller));
		this.winLabel = new Label("TEST", skin, "black");
		
		
		winLabel.setY(stage.getViewport().getScreenHeight()-100);
		
		
		
		this.newGame();
		
	
       
        stage.act();
        for(int i =0; i< 3;i++) {
        	for(int j=0; j<3;j++)
        	{
        	stage.addActor(buttons[i][j]);
        	}
        }
        stage.addActor(resetButton);
        stage.addActor(winLabel);
        
        */
		
	}

	@Override
	public void render () {
		super.render();
		/**
		ScreenUtils.clear(1, 1, 1, 1);
		
	     
        
        Gdx.input.setInputProcessor(stage);
        
        
       
		
		 stage.getViewport().update(stage.getViewport().getScreenWidth(), stage.getViewport().getScreenHeight());
		    stage.draw();
		    stage.act();
		batch.begin();    
		
		batch.end();
		**/
	}
	
	@Override
	public void resize(int width, int height) {
		
		//viewport.update(width, height);
		
	       //stage.getViewport().update(width, height, true);
	        
	}
	
	@Override
	public void dispose () {
		//batch.dispose();
		//img.dispose();
	}
	
	
	public String getCurrentTurn() {
		
		return this.currentTurn;
	}
	public void setCurrentTurn(String turn) {
		
		this.currentTurn = turn;
	}
	
	public void setWinLabelText(String text) {
		
		//this.winLabel.setText(text);
		//stage.draw();
		
		
	}
	
	public void flipButton(int row, int column, GameBoard.State state) {
		
		this.buttons[row][column].setText(state.toString()); 
	}
	
	public void newGame() {
		int x = -200;
		int y = 100;
		
		
		for(int i =0; i< 3;i++) {
        	for(int j=0; j<3;j++)
        	{
        		if(buttons[i][j] != null) {
        	buttons[i][j].remove();
        		}
        	}
        }
		buttons = null;
		buttons = new GameButton[3][3];
		for(int i =0; i<3; i++) {
			
			for(int j = 0; j < 3; j++) {
			buttons[i][j] = new GameButton("",skin);
			buttons[i][j].setSize(100, 100);
			buttons[i][j].setX(stage.getViewport().getScreenWidth()/2+x);
		    buttons[i][j].setY(stage.getViewport().getScreenHeight()/2+y);
		    buttons[i][j].addListener(new GameButtonListener(batch,img, controller));
		    buttons[i][j].setRow(i);
		    buttons[i][j].setColumn(j);
		    stage.addActor(buttons[i][j]);
		    x+=100;
			}
		    	
		    		x = -200;
		    		y-=100;
		    	
		    
		    
		}
		
	}
	
	
}
