package example;



public class Practice2 {

	public static void main(String[] args) {
		A a = new A();
		a.methodA();

	}

}

class A {
	void methodA() {
		I i = InstanceManager.getInstance();
		i.methodB();
		System.out.println(i.toString()); // 모든 객체는 Object 클래스에 정의된 메서드를 가지고 있기에 허용
	}
	
}

interface I {
	public abstract void methodB();
}

class B implements I {
	public void methodB() {
		System.out.println("methodB in B class");
	}
	
	public String toString() { return "class B"; }
}
class InstanceManager {
	public static I getInstance() {
		return new B();
	}
}