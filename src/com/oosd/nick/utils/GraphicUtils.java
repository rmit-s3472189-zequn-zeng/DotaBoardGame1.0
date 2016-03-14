package com.oosd.nick.utils;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.net.URL;

import com.oosd.nick.MainFrame;
import com.oosd.nick.Parameters;
import com.oosd.nick.UI.Point;

public class GraphicUtils {
	
	public static void drawImage(Graphics g,URL url,int x,int y){
    	
    	
     	Image im = Toolkit.getDefaultToolkit().getImage(url);//获取图片，其中"/images/dog.jpg"表示bin目录下的images/dog.jpg
//    		
    		  // 显示图片
    		  g.drawImage(im, x, y, MainFrame.mp);
	}
	
	public static void drawCellBorder(Graphics g,Point p,Color c){
    	
		
    	g.setColor(c);
    	int x = Parameters.boardX + Parameters.cellSize*p.x;
    	int y = Parameters.boardY + Parameters.cellSize*p.y;
		g.drawRect(x, y, Parameters.cellSize, Parameters.cellSize);
		g.drawRect(x+1, y+1, Parameters.cellSize-2, Parameters.cellSize-2);
	}
	
	public static void drawSelectedCellBorder(Graphics g,Point p,Color c){
    	
    	g.setColor(c);
		g.drawRect(Parameters.boardX + Parameters.cellSize*p.x, p.y, Parameters.cellSize, Parameters.cellSize);
		g.drawRect(p.x+1, p.y+1, Parameters.cellSize-2, Parameters.cellSize-2);
	}

}
