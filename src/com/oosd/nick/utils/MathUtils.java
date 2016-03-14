package com.oosd.nick.utils;

public class MathUtils {
	
	public static boolean isPointInRect(int pX,int pY ,int rX,int rY,int width,int height){
		
		return (pX > rX && pY > rY && pX < rX+width && pY < rY+height);
	}
}
