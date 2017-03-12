package com.icss.test;
import java.util.Calendar;
import java.util.Date;


public class Testdate {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		
		Calendar calendar =  Calendar.getInstance();
		System.out.println(calendar.get(Calendar.MONTH));
		System.out.println(calendar.get(Calendar.DAY_OF_MONTH));
		
	}

}
