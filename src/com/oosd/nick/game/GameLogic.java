package com.oosd.nick.game;

import java.util.ArrayList;

import com.oosd.nick.Parameters;
import com.oosd.nick.UI.Component;
import com.oosd.nick.UI.Point;

public class GameLogic {
	
	public ArrayList<Point> getAccessableCellPoint(Point heroLoc ,int movement, Component[][] map, int w,int h){
		int x = heroLoc.x;
		int y = heroLoc.y;
		ArrayList<Point> accessableCells = null; 
		if(map[y][x] != null){
			accessableCells = new ArrayList<Point>(movement*4);
			
			for(int i = heroLoc.x-1; i > heroLoc.x-movement; i--){
				if(i<0) break;
				if(map[y][i] == null){
					accessableCells.add(new Point(i,y));
				}
			}
			for(int i = heroLoc.x+1; i < heroLoc.x+movement; i++){
				if(i>=map[0].length) break;
				if(map[y][i] == null){
					accessableCells.add(new Point(i,y));
				}
			}
			for(int i = heroLoc.y-1; i > heroLoc.y-movement; i--){
				if(i<0)break;
				if(map[i][x] == null){
					accessableCells.add(new Point(x,i));
				}
			}
			for(int i = heroLoc.y+1; i < heroLoc.y+movement; i++){
				if(i>= map.length)break;
				if(map[i][x] == null){
					accessableCells.add(new Point(x,i));
				}
			}
		}
		return accessableCells;
	}

}
