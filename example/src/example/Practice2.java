package example;

import java.util.*;

import javax.swing.JOptionPane;

public class Practice2 {
	static long startTime = 0;
	
	public static void main(String[] args) {
		Runnable r = new RunnableEx12();
		
		new Thread(r).start();
		new Thread(r).start();
	}
	
}

class Account {
	private int balance = 1000;
	
	public synchronized int getBalance() {
		return balance;
	}
	
	public synchronized void withdraw(int money) {
		if(balance >= money) {
			try { Thread.sleep(1000);} catch(InterruptedException e) {}
			balance -= money;
		}
	}
}

class RunnableEx12 implements Runnable {
	Account acc = new Account();
	
	public void run() {
		while(acc.getBalance() > 0) {
			int money = (int)(Math.random() * 3 + 1) * 100;
			acc.withdraw(money);
			System.out.println("balance:" + acc.getBalance());
		}
	}
}