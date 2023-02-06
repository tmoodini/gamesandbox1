package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class GameScreen implements Screen {
	
	private MainGame game;
	private Skin skin;
	private Stage stage;
	private GameButton[][] buttons;
	private SpriteBatch batch;
	private Texture img;
	private GameController controller;

	
	public GameScreen(MainGame game) {
		
		this.game = game;
		
		this.controller = game.getController();
		
		skin = new Skin(Gdx.files.internal("glassy/glassy-ui.json"));
		
		stage = new Stage(new FitViewport(800, 480));
		buttons = new GameButton[3][3];
		
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		
		this.newGame();
		Gdx.input.setInputProcessor(stage);
		//stage.addActor(helloLabel);
		
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
		stage.act();
		
	}

	@Override
	public void resize(int width, int height) {
		// TODO Auto-generated method stub
		
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
		// TODO Auto-generated method stub
		
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
		    buttons[i][j].addListener(new GameButtonListener(batch,img, game));
		    buttons[i][j].setRow(i);
		    buttons[i][j].setColumn(j);
		    stage.addActor(buttons[i][j]);
		    x+=100;
			}
		    	
		    		x = -200;
		    		y-=100;
		    	}
		
		for(int i =0; i< 3;i++) {
        	for(int j=0; j<3;j++)
        	{
        	stage.addActor(buttons[i][j]);
        	}
        }
		
		
		
	}
	public void flipButton(int row, int column, GameBoard.State state) {
		
		this.buttons[row][column].setText(state.toString()); 
	}

}
