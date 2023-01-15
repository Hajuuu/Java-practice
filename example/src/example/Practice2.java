package example;

class Card {
	final int NUMBER;
	final String KIND; // 생성자에서 단 한번만 초기화할 수 있다.
	static int width = 100;
	static int height = 250;
	
	Card(String kind, int num) {
		KIND = kind;
		NUMBER = num;
	}
	
	Card() {
		this("HEART", 1);
	}
	
	public String toString() {
		return KIND + " " + NUMBER;
	}
}
public class Practice2 {

	public static void main(String[] args) {
		Card c = new Card("HEART", 10);
		//c.NUMBER = 5; 
		System.out.println(c.KIND);
		System.out.println(c.NUMBER);
		System.out.println(c);
	}

}