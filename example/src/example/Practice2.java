package example;

import java.util.*;
import java.util.function.*;

class Point {
	int x;
	int y;
}

//class Circle extends Point { // 상속
//	int r; 
//}

class Circle { // 포함
	Point p = new Point();
	int r;
}


public class Practice2 {
	
	public static void main(String[] args) throws Exception {
		Circle c = new Circle();
		c.p.x = 1;
		c.p.y = 2;
		c.r = 3;
		System.out.println("c.x=" + c.p.x);
		System.out.println("c.y=" + c.p.y);
		System.out.println("c.r=" + c.r);
		
	}
	
}

