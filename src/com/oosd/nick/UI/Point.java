package com.oosd.nick.UI;

public class Point {
	
	public int x;
	public int y;
	public Point(int x,int y){
		this.x = x;
		this.y = y;
	}
	@Override
	public boolean equals(Object o) {
		

		if(o == null)return false;
		if(o instanceof Point){
			Point p = (Point)o;
			return p.x == x && p.y == y;
		}
		return false;

	}
	
	
}
