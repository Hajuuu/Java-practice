package example;

import java.util.*;

public class Practice2 {
	
	public static void main(String[] args) {
		Set set = new TreeSet(); //범위 검색, 정렬. 정렬 필요없음
		
//		for(int i = 0; set.size() < 6; i++) {
//			int num = (int)(Math.random()*45) + 1;
			set.add(new Test());
//		}
		System.out.println(set);
	}
}

//객체가 비교 기준을 가지고 있거나 treeset이 비교 기준을 갖고있어야함.

class Test implements Comparable {

	@Override
	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}

class TestComp implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		return 0;
	}
	
}