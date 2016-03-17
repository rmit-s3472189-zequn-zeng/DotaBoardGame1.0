package com.oosd.nick.UI;

import java.awt.Color;
import java.awt.Graphics;

public class MenuItem extends Menu{

	
	private String item []={" ","Moving","Attack"};
	public int len=item.length;
	public MenuItem(Graphics g, Point loc) {
		super(g, loc);
		drawcell(g);
		addItem(g);
	}
	
	public void drawcell(Graphics g){
		for (int i=0;i<len-1;i++){
			g.drawRect(locx, locy+i*50, 50, 50);
		}
	}
	
	public void addItem(Graphics g){
		for(int i =0;i<item.length;i++){
			g.setColor(Color.DARK_GRAY);
			g.drawString(item[i], locx+10, locy+50*i-25);
		}
	}
}
