package example;

import java.util.*;

public class Practice2 {
	
	public static void main(String[] args) {
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		
		if(v1.equals(v2))
			System.out.println("v1과 v2는 같습니다.");
		else
			System.out.println("v1과 v2는 다릅니다.");
		
	}
	
}

class Value {
	int value;
	
	Value(int value) {
		this.value = value;
	}
	
	public boolean equals(Object obj) {
//		Value v = (Value) obj; // obj를 value로 형변환
//		
//		return this.value == v.value;
		return this == obj; //주소 비교, 서로 다른 객체는 항상 거짓
	}
}

