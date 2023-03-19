package example;

import java.util.*;

public class Practice2 {
	static long startTime = 0;
	
	public static void main(String[] args) {
		ThreadEx1_1 t1 = new ThreadEx1_1();
		
		Runnable r = new ThreadEx1_2();
		Thread t2 = new Thread(r);
		
		t1.start();
		t2.start();
		
		startTime = System.currentTimeMillis();
		
		try {
			t1.join(); // main쓰레드가 t1의 작업이 끝날 때까지 기다린다.
			t2.join(); // main쓰레드가 t2의 작업이 끝날 때까지 기다린다.
		} catch(InterruptedException e) {}
		
		System.out.print("소요시간: " + (System.currentTimeMillis() - startTime));
	}
}

class ThreadEx1_1 extends Thread { // Thread클래스를 상속해서 쓰레드를 구현
	public void run() { // 쓰레드가 수행할 작업을 작성
		for(int i = 0; i < 300; i++) {
			System.out.print(new String("-")); // 조상인 Thread의 getName()을 호출
		}
	}
}

class ThreadEx1_2 implements Runnable { // Runnable인터페이스를 구현해서 쓰레드를 구현
	public void run() { // 쓰레드가 수행할 작업을 작성
		for(int i = 0; i < 300; i++) {
			// Thread.currentThread() - 현재 실행중인 Thread를 반환한다.
			System.out.print(new String("ㅣ"));
		}
	}
}