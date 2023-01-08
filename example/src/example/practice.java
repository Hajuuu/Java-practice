package example;

class Tv{
	//Tv의 속성(멤버변수)
	String color;
	boolean power;
	int channel;
	
	//Tv의 기능(메서드)
	void power() {power = !power;}
	void channelUp() {++channel;}
	void channelDown() {--channel;}
}
public class practice {

	public static void main(String[] args) {
		Tv[] tvArr  = new Tv[3];
		
		for(int i=0; i < tvArr.length; i++) {
			tvArr[i] = new Tv();
			tvArr[i].channel = i+10;
		}
		
		for(int i=0; i < tvArr.length; i++) {
			tvArr[i].channelUp();
			System.out.printf("tvArr[%d].channel=%d%n",i,tvArr[i].channel);
		}
	}

}
