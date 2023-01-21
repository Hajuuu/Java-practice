package example;

class A {
	public void methodA(B b) {
		b.methodB();
	}
}

class B {
	public void methodB() {
		System.out.println("methodB()");
	}
}

public class Practice2 {

	public static void main(String[] args) {
		A a = new A();
		a.methodA(new B());
	}

}