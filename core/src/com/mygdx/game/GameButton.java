package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;

public class GameButton extends TextButton{

	private boolean selected;
	private int row;
	private int column;
	
	
	public int getRow() {
		return row;
	}


	public void setRow(int row) {
		this.row = row;
	}


	public int getColumn() {
		return column;
	}


	public void setColumn(int column) {
		this.column = column;
	}


	public GameButton(String text, Skin skin) {
		super(text, skin);
		selected = false;
		// TODO Auto-generated constructor stub
	}
	
	
	public boolean userSelects(String selection) {
		
		if(!this.selected) {
		this.setSelected(true);
		this.setText(selection);
			return true;
		}else {
			return false;
		}
		
	
	}
	public boolean getSelected() {
		return selected;
	}
	
	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	
	

}
