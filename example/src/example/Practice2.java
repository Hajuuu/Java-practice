package example;

import java.util.*;

import javax.swing.JOptionPane;


public class Practice2 {
	
	public static void main(String[] args) throws Exception {
//		MyFunction f = new MyFunction() {
//			public int max(int a, int b) { //오버라이딩 - 접근제어자는 좁게 못바꾼다.
//				return a > b ? a : b;
//			}
//		};
		
		//람다식(익명 객체)을 다루기 위한 참조변수의 타입은 함수형 인터페이스로 한다.
		MyFunction f = (a, b) -> a > b ? a : b;
		
		int value = f.max(3, 5);
		System.out.println("value=" + value);
	}
	
}

@FunctionalInterface
interface MyFunction {
	public abstract int max(int a, int b);
}
