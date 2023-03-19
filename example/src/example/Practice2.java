package example;

import java.util.*;

class Parent {
	void parentMethod() { }
}

class Child extends Parent {
	@Override
	@Deprecated
	void parentMethod() { } // 조상 메서드의 이름을 잘못 적음.
}

@FunctionalInterface
interface Testable {
	void test(); // 추상메서드
//	void check(); // 추상메서드
}

public class Practice2 {
	
	public static void main(String[] args) {
		Child c = new Child();
		c.parentMethod();
	}
}


