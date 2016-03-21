package com.oosd.nick.UI.menu;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseListener;

import com.oosd.nick.UI.Component;
import com.oosd.nick.UI.Point;
import com.oosd.nick.game.heroInfo;

public class Menu extends Component{

	private heroInfo hero_info;
	int  locx,locy; //location of menue;
	Point p;
	public Menu (Graphics g, Point loc){
		p=loc;
		locx=loc.x;
		locy=loc.y;
		
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		new MenuItem(g,p);
	}

	@Override
	public boolean onMouseClicked(Point p) {
		
		return false;
	}
}
