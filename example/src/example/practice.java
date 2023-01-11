package example;

public class practice {

	// 클래스 초기화 블럭
	static {
		System.out.println("static {  }");
	}
	
	// 인스턴스 초기화 블럭
	{
		System.out.println("{ }");
	}
	
	public practice() {
		System.out.println("생성자");
	}
	
	
	public static void main(String[] args) {
		System.out.println("practice bt = new practice(); ");
		practice bt = new practice();
		
		System.out.println("practice bt2 = new practice(); ");
		practice bt2 = new practice();
	}
}