package com.mygdx.game;


import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Camera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.Viewport;


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
	private GameScreen gameScreen;
	private MainMenuScreen mainMenu;
	
	public MainGame(GameController controller) {
		
		this.controller = controller;		
	}
	
	@Override
	public void create () {
	
		skin = new Skin(Gdx.files.internal("glassy/glassy-ui.json"));
		this.mainMenu = new MainMenuScreen(this);
		this.gameScreen = new GameScreen(this);
		this.setScreen(mainMenu);
				
	}
	
	public void changeToGameScreen() {
		this.gameScreen = new GameScreen(this);
		this.setScreen(gameScreen);
	}
	
	public void changeToMainMenuScreen() {
		//this.gameScreen = new GameScreen(this);
		this.setScreen(mainMenu);
	}
	
	public void newGame() {
		this.gameScreen.newGame();	
	}

	@Override
	public void render () {
		super.render();
		
	}
	
	@Override
	public void resize(int width, int height) {

	}
	
	@Override
	public void dispose () {
		
	}
	
	
	public String getCurrentTurn() {
		
		return this.currentTurn;
	}
	public void setCurrentTurn(String turn) {
		
		this.currentTurn = turn;
	}
	
	public void setWinLabelText(String text) {

	}
	
	
	

	public GameController getController() {
		return controller;
	}

	public void setController(GameController controller) {
		this.controller = controller;
	}
	
	public void flipButton(int row, int column, GameBoard.State state) {
		
		
		this.gameScreen.flipButton(row, column, state);
		
	}

	public GameScreen getGameScreen() {
		return gameScreen;
	}

	public void setGameScreen(GameScreen gameScreen) {
		this.gameScreen = gameScreen;
	}
	
	
}
