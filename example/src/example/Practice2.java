package example;

final class Singleton {
	private static Singleton s = new Singleton();
	
	private Singleton() {
		
	}
	
	public static Singleton getInstance() {
		if(s==null) {
			s = new Singleton();
		}
		return s;
	}
}
public class Practice2 {

	public static void main(String[] args) {
		//Singleton s = new Singleton(); error, Singleton() has private access in Singleton
		Singleton s = Singleton.getInstance();
	}

}
