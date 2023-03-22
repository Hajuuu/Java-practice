package example;

import java.util.*;

import javax.swing.JOptionPane;

public class Practice2 {
	
	public static void main(String[] args) {
		ThreadEx6_1 th1 = new ThreadEx6_1();
		ThreadEx6_2 th2 = new ThreadEx6_2();
		
		//th1.setPriority(5); 가 생략된 것
		th2.setPriority(9);
		
		System.out.println("Priority of th1(-) : " + th1.getPriority());
		System.out.println("Priority of th2(ㅣ) : " + th2.getPriority());
		th1.start();
		th2.start();
		
	}
}

class ThreadEx6_1 extends Thread {
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print("-");
			for(int x = 0; x < 10000000; x++); //시간지연용
		}
	}
}

class ThreadEx6_2 extends Thread {
	public void run() {
		for(int i = 0; i < 300; i++) {
			System.out.print("ㅣ");
			for(int x = 0; x < 10000000; x++); //시간지연용
		}
	}
}
