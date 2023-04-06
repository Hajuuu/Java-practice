package example;

import java.util.*;
import java.util.function.*;


public class Practice2 {
	
	public static void main(String[] args) throws Exception {
		MyMath mm = new MyMath(3, 4);
		long result = MyMath.add(3L, 4L);
		int result2 = mm.add(3,4);
		long result3 = mm.add();
		System.out.println(result + " " + result2 + " " + result3);
	}
	
}

class MyMath {
	long a, b;
	int sum = 5;
	
	MyMath(int a, int b) {
		this.a = a;
		this.b = b;
	}
	
	long add() {
		return this.a + this.b;
	}
	
	static long add(long a, long b) {
		return a + b;
	}
	
	int add(int a, int b) {
		return sum + a + b;
	}
}
