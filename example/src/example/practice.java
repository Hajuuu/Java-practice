package example;


public class practice {

	public static void main(String[] args) {
		firstMethod();
	}
	
	static void firstMethod() {
		secondMethod();
	}
	
	static void secondMethod() {
		System.out.println("secondMethod()");
	}

}
