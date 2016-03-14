package com.oosd.nick;

import java.util.ArrayList;

import com.oosd.nick.UI.Component;
import com.oosd.nick.UI.GameBoard;
import com.oosd.nick.UI.Point;
import com.oosd.nick.UI.Spirit;
import com.oosd.nick.game.GameLogic;

public class Game {
	private GameBoard gameBoard;
	private GameLogic logic;
	public Game(GameBoard gameBoard){
		this.gameBoard = gameBoard;
		this.logic = new GameLogic();
	}
	
	public ArrayList<Point> getAccessableCellPoint(Point heroLoc ,int movement, Spirit[][] map, int w,int h){
		return logic.getAccessableCellPoint(heroLoc, movement, map, w, h);
	}
}
