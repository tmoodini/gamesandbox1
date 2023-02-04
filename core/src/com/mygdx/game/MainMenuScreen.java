package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.ScreenUtils;
import com.badlogic.gdx.utils.viewport.FitViewport;

public class MainMenuScreen implements Screen {
	
	private MainGame game;
	private TextButton startButton;
	private Skin skin;
	private Stage stage;
	private Label helloLabel;
	
	public MainMenuScreen(final MainGame game) {
		this.game = game;
		
		
		skin = new Skin(Gdx.files.internal("glassy/glassy-ui.json"));
		
		this.helloLabel = new Label("TEST", skin, "black");
	
		stage = new Stage(new FitViewport(800, 480));
		
		stage.addActor(helloLabel);
		
	}

	@Override
	public void show() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(float delta) {
		ScreenUtils.clear(1, 1, 1, 1);
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
		// TODO Auto-generated method stub
		
	}

}
