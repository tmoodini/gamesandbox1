package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.GameController.MoveResult;

public class GameScreen implements Screen {
	
	private MainGame game;
	private Skin skin;
	private Stage stage;
	private GameButton[][] buttons;
	private SpriteBatch batch;
	private Texture img;
	private GameController controller;
	private Texture winLoseDrawImage;
	private TextButton newGameButton;
	private TextButton mainMenuButton;
	private TextureRegion winLoseDrawRegion;
	private Image winLoseDrawActor;
	private Table buttonTable;
	private Table gameButtonTable;
	

	public GameScreen(final MainGame game) {
		
		this.game = game;
		
		this.controller = game.getController();
		
		skin = new Skin(Gdx.files.internal("glassy/glassy-ui.json"));
		
		stage = new Stage(new FitViewport(800, 800));
		buttons = new GameButton[3][3];
		
		newGameButton = new TextButton("NEW GAME", skin);
		mainMenuButton = new TextButton("Main Menu", skin);	
		gameButtonTable = new Table();
		//gameButtonTable.setSize(300, 300);
		buttonTable = new Table();
		
		newGameButton.addListener(new InputListener() {
	        
	        @Override 
	    	public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
	            //Gdx.app.log("my app", "Pressed"); //** Usually used to start Game, etc. **//
	           TextButton b1 = (TextButton) event.getListenerActor();
	           game.getController().newGame();
	            return true;
	        }
	    });
		
		mainMenuButton.addListener(new InputListener() {
	        
	        @Override 
	    	public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
	            //Gdx.app.log("my app", "Pressed"); //** Usually used to start Game, etc. **//
	           TextButton b1 = (TextButton) event.getListenerActor();
	           game.changeToMainMenuScreen();
	            return true;
	        }
	    });
		
		buttonTable.add(newGameButton);
		buttonTable.add(mainMenuButton);
		buttonTable.setX(stage.getViewport().getScreenWidth()/2);
		buttonTable.setY(100);
		
		stage.addActor(buttonTable);
		
		this.newGame();
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
		stage.dispose();
		
	}
	
	public void newGame() {
		int x = -200;
		int y = 100;
		
		
		
		if(winLoseDrawActor != null) {
			winLoseDrawActor.remove();
		}
		
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
			//buttons[i][j].setX(stage.getViewport().getScreenWidth()/2+x);
		   // buttons[i][j].setY(stage.getViewport().getScreenHeight()/2+y);
		    buttons[i][j].addListener(new GameButtonListener(batch,img, game));
		    buttons[i][j].setRow(i);
		    buttons[i][j].setColumn(j);
		    
		    //stage.addActor(buttons[i][j]);
		    gameButtonTable.add(buttons[i][j]).width(150);
		    x+=100;
			}
		    	gameButtonTable.row();
		    		x = -200;
		    		y-=100;
		    	}
		/**
		for(int i =0; i< 3;i++) {
        	for(int j=0; j<3;j++)
        	{
        	stage.addActor(buttons[i][j]);
        	}
        }**/
		gameButtonTable.setX(stage.getViewport().getScreenWidth()/2);
		gameButtonTable.setY(stage.getViewport().getScreenHeight()/2);
		//gameButtonTable.setWidth(stage.getViewport().getScreenWidth()*.75f);
		stage.addActor(gameButtonTable);
	
		
	}
	public void flipButton(int row, int column, GameBoard.State state) {
		
		this.buttons[row][column].setText(state.toString()); 
	}
	
	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}
	
	public void aiMove() {
		
		game.getController().aiMove();
	}
	
	public void gameOver(GameController.MoveResult finish, GameBoard.State state) {
		
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j <3; j++) {
				buttons[i][j].remove();
			}
		}
		
		if(finish == MoveResult.DRAW) {
		winLoseDrawImage = new Texture(Gdx.files.internal("DRAW.png"));
        this.winLoseDrawRegion = new TextureRegion(winLoseDrawImage, 0, 0, 512, 275); 
        winLoseDrawActor = new Image(winLoseDrawRegion);
        winLoseDrawActor.setY(500);
        stage.addActor(winLoseDrawActor);
        stage.act();
		}
		
		if(finish == MoveResult.WIN) {
			if(state == GameBoard.State.X) {
				winLoseDrawImage = new Texture(Gdx.files.internal("XWINS.png"));
				winLoseDrawRegion = new TextureRegion(winLoseDrawImage, 0, 0, 512, 275); 
				
				winLoseDrawActor = new Image(winLoseDrawRegion);
				winLoseDrawRegion.setRegionWidth(winLoseDrawImage.getWidth());
				winLoseDrawActor.setY(500);
		        stage.addActor(winLoseDrawActor);
			}
			if(state == GameBoard.State.O) {
				winLoseDrawImage = new Texture(Gdx.files.internal("OWINS.png"));
				winLoseDrawRegion = new TextureRegion(winLoseDrawImage, 0, 0, 512, 275);  
				winLoseDrawRegion.setRegionWidth(winLoseDrawImage.getWidth());
				
				winLoseDrawActor = new Image(winLoseDrawRegion);
				winLoseDrawActor.setY(500);
		        stage.addActor(winLoseDrawActor);
			}
		}
		
	}


}
