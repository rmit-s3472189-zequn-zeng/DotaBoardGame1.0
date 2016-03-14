package com.oosd.nick.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import com.oosd.nick.Game;
import com.oosd.nick.Parameters;
import com.oosd.nick.game.GameLogic;
import com.oosd.nick.utils.GraphicUtils;
import com.oosd.nick.utils.MathUtils;
public class GameBoard extends Component  implements MouseListener {
	
	private int x;
	private int y;
	private int width;
	private int height;
	private int mX,mY,mW,mH;
	private GameLogic gLogic;


	private Component[][] map = new Component[Parameters.CELL_ROWS][Parameters.CELL_COLUMNS];
	private Hero baihu;
	private Game game;
	private Map gameMap;
	
	public GameBoard(int x ,int y ,int width,int height){
		
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.mX = Parameters.boardX = this.x + (this.width - (Parameters.cellSize*Parameters.CELL_COLUMNS))/2;
		this.mY = Parameters.boardY = this.y + (this.height - (Parameters.cellSize*Parameters.CELL_ROWS)-50);
		this.mW = Parameters.cellSize*Parameters.CELL_COLUMNS;
		this.mH = Parameters.cellSize*Parameters.CELL_ROWS;
		this.gameMap =  new Map(this,mX,mY,mW,mH);
		game = new Game(this);
		
	}
	@Override
	public void draw(Graphics g) {
        	
        	drawBoard(g);
	}
	private void drawBoard(Graphics g){
		this.gameMap.draw(g);
	}
	

	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int cX = e.getX();
		int cY = e.getY()-Parameters.WINDOW_TITTLE_HEIGHT;
		
		this.onMouseClicked(new Point(cX,cY));

		
	}
	
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public boolean onMouseClicked(Point p) {
		if(this.gameMap.isInRect(p)){
			 return gameMap.onMouseClicked(p);

		}
		return false;
	}
	protected Game getGame(){
		return this.game;
	}

}
