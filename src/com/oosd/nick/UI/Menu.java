package com.oosd.nick.UI;


import java.awt.Color;
import java.awt.Graphics;

import com.oosd.nick.UI.Component;
import com.oosd.nick.UI.Point;
import com.oosd.nick.game.heroInfo;

public class Menu extends Component{

	private heroInfo hero_info;
	int amount = 5;
	int  locx,locy; //location of menue;
	public Menu (Graphics g, Point loc){
		locx=loc.x;
		locy=loc.y;
		
	}
	
	public  void setamount(int amount){
		this.amount=amount;
	}
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.RED);
		for (int i=0;i<amount;i++){
			g.drawRect(locx, locy+i*50, 50, 50);
		}
		for(int i =1;i<=amount;i++){
			g.setColor(Color.DARK_GRAY);
			g.drawString("Test", locx+10, locy+50*i-25);
		}
	}

	@Override
	public boolean onMouseClicked(Point p) {
		// TODO Auto-generated method stub
		return false;
	}
}
