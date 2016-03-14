package com.oosd.nick.UI;

import java.awt.Graphics;

import com.oosd.nick.utils.MathUtils;

public abstract class Component {

	int x,y,width,height;
	
	public boolean isInRect(Point p){
		
		return MathUtils.isPointInRect(p.x, p.y, x, y, width, height);
	}

	abstract public void draw(Graphics g);
	
	abstract public boolean onMouseClicked(Point p);
}
