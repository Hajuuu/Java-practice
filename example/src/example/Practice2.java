package example;

import java.util.*;

public class Practice2 {
	
	public static void main(String[] args) {
		ArrayList list1 = new ArrayList(10);
		//ArrayList에는 객체만 저장가능
		list1.add(5); //오토박싱
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		
		
//		List sub = list1.subList(1,4);
//		ArrayList list2 = new ArrayList(sub);
		ArrayList list2 = new ArrayList(list1.subList(1,4));
		print(list1, list2);
		
		// Collection은 인터페이스, Collections는 유틸 클래스(ex: Math 클래스)
		Collections.sort(list1);
		Collections.sort(list2);
		print(list1, list2);
			
		System.out.println("list1.containsAll(list2):"+list1.containsAll(list2));
	
		list2.add("B");
		list2.add("C");
		list2.add(3, "A");
		print(list1, list2);
		
		list2.set(3, "AA");
		print(list1, list2);
		
		list1.add(0, "1");
		System.out.println("index="+list1.indexOf(new Integer(1)));
		System.out.println("index="+list1.indexOf("1"));
		
		//list1.remove(1); //인덱스가 1인 객체를 삭제
		list1.remove(new Integer(1));		
		print(list1, list2);
		
		//list1에서 list2와 겹치는 부분만 남기고 나머지는 삭제
		System.out.println("list1.retainAll(list2):"+ list1.retainAll(list2));
		print(list1, list2);
		
		// list2에서 list1에 포함된 객체들을 삭제
		for(int i = list2.size()-1; i >= 0; i--) {
			if(list1.contains(list2.get(i)))
				list2.remove(i);
		}
		print(list1, list2);
	}

	
	static void print(ArrayList list1, ArrayList list2) {
		System.out.println("list1:"+list1);
		System.out.println("list2:"+list2);
		System.out.println();
	}
	
}

