package chapter7.jiekou;

import java.util.Arrays;

import chapter6.mypoint.MyPoint;

/**
 * 实现对对象类型的排序
 * @author Administrator
 *
 */
public class TestSort {

	public static void main(String[] args) {
		
		MyPoint[] a = new MyPoint[3];
		a[0] = new MyPoint(25,3);
		a[1] = new MyPoint(13,3);
		a[2] = new MyPoint(4,3);
				
		Arrays.sort(a);
		
		for (MyPoint item : a) {
			System.out.println(item);
		}

	}

}