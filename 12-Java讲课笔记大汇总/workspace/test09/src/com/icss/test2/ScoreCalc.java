package com.icss.test2;

public class ScoreCalc {
	public int java;
	public int c;
	public int db;
	
	public double getAvg(){
		
		return (java + c + db) / 3.0;
	}
	
	public void showAvg(){
		System.out.println(getAvg());
	}
	}
