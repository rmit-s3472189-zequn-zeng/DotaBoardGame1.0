package com.oosd.nick.UI;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import com.oosd.nick.MainFrame;
import com.oosd.nick.Parameters;
import com.oosd.nick.game.GameLogic;
import com.oosd.nick.utils.GraphicUtils;
import com.oosd.nick.utils.MathUtils;
//cells : 25*12 size:50
public class GameBoard extends Component  implements MouseListener {

//	public static final int CELL_SIZE = 50;
//	public static final int CELL_ROW = 24;
//	public static final int CELL_COLUMN = 12;
	
	private int x;
	private int y;
	private int width;
	private int height;
	private int boundry;
	private int mX,mY,mW,mH;
	private boolean isLocked = false;
	private MainFrame mFrame;
	private GameLogic gLogic;
	private Hero selectedHero;
	private ArrayList<Point> accessableCells = null;
	private Component[][] map = new Component[Parameters.CELL_ROWS][Parameters.CELL_COLUMNS];
	Hero baihu;
	
	public GameBoard(MainFrame frame, int x ,int y ,int width,int height){
		
	
		gLogic = new GameLogic();
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
		this.mFrame = frame;
		
		this.boundry = 50;
		this.mX = Parameters.boardX = this.x + (this.width - (Parameters.cellSize*Parameters.CELL_COLUMNS))/2;
		this.mY = Parameters.boardY = this.y + (this.height - (Parameters.cellSize*Parameters.CELL_ROWS)-50);
		this.mW = Parameters.cellSize*Parameters.CELL_COLUMNS;
		this.mH = Parameters.cellSize*Parameters.CELL_ROWS;
		baihu =  new Hero(GameBoard.class.getResource("/hero1.png"));
		map[5][5] = baihu;
		baihu.setLocation(5, 5);
		
	}
	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
        {
        	
        	drawBoard(g);
        	
//        	
//            int begin,end;
//            begin=0;
//
//            while(begin!=360)
//            {
//
//            	
//            	//draw boundary lines
//            	
//              //Color(int, int, int) 
//             //用指定的红、绿和兰色成分创建一个颜色。
//              Color c=new Color((int)(Math.random()*255),(int)(Math.random()*255),(int)(Math.random()*255));
//              g.setColor(Color.red);
//                                                                   
//
//     //drawArc(int, int, int, int, int, int) 
//                                                                    
//
//      //绘制一个覆盖指定矩形的圆或椭圆弧的轮廓
//              g.drawArc(150,150,200,200,begin,36);
//              g.setColor(c);
//          //fillArc(int, int, int, int, int, int) 
//                                          //填充一个覆盖了指定矩形的圆或椭圆弧。
//              g.fillArc(150,150,200,200,begin,36);
//              begin+=36;
//            } 
    }
	}
	private void drawBoard(Graphics g){
		Color c = g.getColor();
    	g.setColor(Color.BLACK);
    	
    	
//    	g.drawRect(mX, mY, this.mW, this.mH);
    	for(int i = 0 ; i <= Parameters.CELL_ROWS ; i++){
    		g.drawLine(mX, mY+i*Parameters.cellSize, mX+mW, mY+i*Parameters.cellSize);
    	}
    	
    	for(int i = 0 ; i <= Parameters.CELL_COLUMNS ; i++){
    		g.drawLine(mX+i*Parameters.cellSize, mY, mX+i*Parameters.cellSize, mY+mH);
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
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		int cX = e.getX();
		int cY = e.getY()-Parameters.WINDOW_TITTLE_HEIGHT;
		if(MathUtils.isPointInRect(cX, cY, mX, mY, mW, mH)){
			
			int cellIndexX = (cX - mX)/Parameters.cellSize;
			int cellIndexY= (cY - mY)/Parameters.cellSize;
			Point clickedCell = new Point(cellIndexX,cellIndexY);
	
			if(map[cellIndexY][cellIndexX] != null){
				Component c = map[cellIndexY][cellIndexX];
				if(c instanceof Hero){
					selectedHero = (Hero)c;
					selectedHero.setSelected(true);
					accessableCells = gLogic.getAccessableCellPoint(new Point(cellIndexX,cellIndexY), 5, map, Parameters.CELL_COLUMNS, Parameters.CELL_ROWS);
				}
			}else{
				if(this.selectedHero!=null){
					
					if(accessableCells != null ){
						for(Point p : accessableCells){
							if(clickedCell.equals(p)){
								moveTo(baihu,clickedCell);
								break;
							}
						}
					}
					this.selectedHero.setSelected(false);
					accessableCells = null;
				}
			}
			
		}
		
	}
	private void moveTo(Hero hero,Point target){
		Point curLoc = hero.getLoc();
		this.map[curLoc.y][curLoc.x] = null;
		this.map[target.y][target.x] = hero;
		hero.setLocation(target.x,target.y);
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

}
