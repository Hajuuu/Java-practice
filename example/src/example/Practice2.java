package example;

import java.util.*;
import java.util.function.*;


public class Practice2 {
	
	public static void main(String[] args) throws Exception {
		Supplier<Integer> s = () -> (int)(Math.random()*100)+1;
		Consumer<Integer> c = i -> System.out.print(i + ", "); // 출력
		Predicate<Integer> p = i -> i % 2 == 0; // 짝수인지 검사
		Function<Integer, Integer> f = i -> i / 10 * 10;
		
		List<Integer> list = new ArrayList<>();
		makeRandomList(s, list); // list를 랜덤값으로 채운다.
		System.out.println(list);
		printEvenNum(p, c, list); // 짝수를 출력
		List<Integer> newList = doSomething(f, list);
		System.out.println(newList);
	}
	
	static <T> List<T> doSomething(Function<T, T> f, List<T> list) {
		List<T> newList = new ArrayList<T>(list.size());
		
		for(T i : list) {
			newList.add(f.apply(i));
		}
		
		return newList;
	}
	
	static <T> void printEvenNum(Predicate<T> p, Consumer<T> c, List<T> list) {
		System.out.print("[");
		for(T i : list) {
			if(p.test(i)) { // 짝수인지 검사
				c.accept(i); // i -> System.out.print(i+", "); 화면에 i 출력
			}
		}
		System.out.println("]");
	}
	
	static <T> void makeRandomList(Supplier<T> s, List<T> list) {
		for(int i = 0; i < 10; i++) {
			list.add(s.get()); //Supplier로 부터 1~100의 난수를 받아서 list에 추가
		}
	}
	
}
