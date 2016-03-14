package com.oosd.nick.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import com.oosd.nick.Game;
import com.oosd.nick.Parameters;
import com.oosd.nick.utils.GraphicUtils;

public class Map extends Component{

	private GameBoard gameBoard;
	private Hero selectedHero;
	private Spirit map[][] = new Spirit[Parameters.CELL_ROWS][Parameters.CELL_COLUMNS];
	private ArrayList<Point> accessableCells = null;
	private Hero baihu;
	public 	Map(GameBoard gb,int x,int y,int w,int h){
		this.gameBoard = gb;
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
		
		/* test code add by nick */
		baihu =  new Hero(GameBoard.class.getResource("/hero1.png"));
		map[5][5] = baihu;
		baihu.setLocation(5, 5);
	}
	@Override
	public void draw(Graphics g) {
		
		Color c = g.getColor();
    	g.setColor(Color.BLACK);

    	for(int i = 0 ; i <= Parameters.CELL_ROWS ; i++){
    		g.drawLine(x,y +i*Parameters.cellSize, x+width, y+i*Parameters.cellSize);
    	}
    	
    	for(int i = 0 ; i <= Parameters.CELL_COLUMNS ; i++){
    		g.drawLine(x+i*Parameters.cellSize, y, x+i*Parameters.cellSize, y+height);
    	}
    	drawcomponents(g);
    	drawAccessableCells(g);
    	
    	g.setColor(c);
		
	} 
	
	private void drawcomponents(Graphics g){
		
		for(int i = 0 ; i < Parameters.CELL_ROWS ; i ++){
			for(int j = 0 ; j < Parameters.CELL_COLUMNS ; j ++){
				if(map[i][j] != null){
					map[i][j].draw(g);
				}
			}
			
		}
	}
	
	private void drawAccessableCells(Graphics g){
		
		
		if(selectedHero!= null && this.accessableCells != null && accessableCells.size() != 0){
			for(Point p : accessableCells){
				GraphicUtils.drawCellBorder(g, p, Color.orange);
			}
		}
	}
	@Override
	public boolean onMouseClicked(Point p) {
		int cellIndexX = (p.x - x)/Parameters.cellSize;
		int cellIndexY= (p.y - y)/Parameters.cellSize;
		Point clickedCell = new Point(cellIndexX,cellIndexY);

		if(map[cellIndexY][cellIndexX] != null){
			Component c = map[cellIndexY][cellIndexX];
			if(c instanceof Hero){
				selectedHero = (Hero)c;
				selectedHero.setSelected(true);
				accessableCells = this.gameBoard.getGame().getAccessableCellPoint(new Point(cellIndexX,cellIndexY), 5, map, Parameters.CELL_COLUMNS, Parameters.CELL_ROWS);
			}
		}else{
			if(this.selectedHero!=null){
				
				if(accessableCells != null ){
					for(Point pp : accessableCells){
						if(clickedCell.equals(pp)){
							moveTo(baihu,clickedCell);
							break;
						}
					}
				}
				this.selectedHero.setSelected(false);
				accessableCells = null;
			}
		}
		return true;
	}
	
	private void moveTo(Hero hero,Point target){
		Point curLoc = hero.getLoc();
		this.map[curLoc.y][curLoc.x] = null;
		this.map[target.y][target.x] = hero;
		hero.setLocation(target.x,target.y);
	}
	

}
