package com.oosd.nick.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import com.oosd.nick.Parameters;
import com.oosd.nick.utils.GraphicUtils;

public class Hero extends Spirit {

	

	private Point loc;
	private int locX;
	private int locY;
	private URL url;
	private boolean selected = false;

	private Menu m;

	public Hero(URL url){
		this.url = url;
	}
	
	public void setLocation(int x,int y){

		locX = Parameters.boardX + Parameters.cellSize*x;
		locY = Parameters.boardY + Parameters.cellSize*y;
		loc = new Point(x,y);
	}


	@Override
	public void draw(Graphics g) {
		
		// TODO Auto-generated method stub
		GraphicUtils.drawImage(g, url, locX, locY);
		if(selected){
			GraphicUtils.drawCellBorder(g,loc,Color.blue);
			// when hero selected, the menu will show on screen.
			m=new Menu(g,loc);
			m.draw(g);
		}
	}

	
	public boolean isSelected() {
		return selected;
	}

	public void setSelected(boolean selected) {
		this.selected = selected;
	}
	
	public Point getLoc() {
		return loc;
	}


}
