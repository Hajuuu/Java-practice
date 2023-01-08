package example;

public class practice {

	public static void main(String[] args) {
		int[] x = {100};
		System.out.println("main() : x = "+x[0]);
		
		change(x);
		System.out.println("After change (d.x)");
		System.out.println("main() : x = "+x[0]);
	}
	
	static void change(int[] x) { // 참조형 매개변수
		x[0] = 1000;
		System.out.println("change () :  x = "+x[0]);
	}

}
