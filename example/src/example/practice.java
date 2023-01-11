package example;

public class practice {

	static {
		System.out.println("static {  }");
	}
	
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