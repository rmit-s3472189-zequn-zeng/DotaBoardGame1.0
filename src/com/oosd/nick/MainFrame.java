package com.oosd.nick;

import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.net.MalformedURLException;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.Timer;

import com.oosd.nick.UI.GameBoard;

public class MainFrame extends javax.swing.JFrame{
	
	public int x=0,y=0;
	private GameBoard gBoard = null;
	public static MainPanel mp;
	
	public MainFrame()
    {
       this.setTitle("Dota Borad Game 1.0");
       this.setBounds(x, y, Parameters.MAIN_WINDOW_WIDTH, Parameters.MAIN_WINDOW_HEIGHT); //set main windows size
       gBoard = new GameBoard(this,x,y,Parameters.MAIN_WINDOW_WIDTH,Parameters.MAIN_WINDOW_HEIGHT);
       mp=new MainPanel();   //实例化一个panel
       this.add(mp);    //加载panel
       this.addMouseListener(gBoard);
       clock.start();   
       this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
    }
    Timer clock= new Timer(Parameters.TIME_DELAY, new ActionListener(){

		@Override
		public void actionPerformed(ActionEvent e)
        {
            mp.repaint();
        }
    	
    });
    
    class MainPanel extends javax.swing.JPanel
    {
        public   void paint(Graphics g) {
        super.paint(g);
        	MainFrame.this.gBoard.draw(g);
        }
    }


}

