package example;

import java.util.*;
import java.util.function.*;

class Point {
	int x;
	int y;
	
	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public String toString() {
		return "x:" + x +", y:" + y;
	}
}


public class Practice2 {
	
	public static void main(String[] args) throws Exception {
		Point p = new Point(3,5);
		System.out.println(p);
		
	}
	
}

