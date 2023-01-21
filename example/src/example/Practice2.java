package example;

class A {
	public void method(I i) { // 인터페이스 I를 구현한 것만 매개변수 이용가능
		i.method();
	}
}

interface I {
	public void method();
}

class B implements I {
	public void method() {
		System.out.println("B클래스의 메서드");
	}
}

class C {
	public void method() {
		System.out.println("C클래스의 메서드");
	}
}

public class Practice2 {

	public static void main(String[] args) {
		A a = new A();
		a.method(new B());
	}

}