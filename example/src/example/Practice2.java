package example;

public class Practice2 {

	public static void main(String[] args) {
		Car car = null;
		FireEngine fe = new FireEngine();
		FireEngine fe2 = null;
		
		fe.water();
		car = fe;
		//car.water(); error. Car 타입의 참조변수인 car로는 water()를 사용 불가.
		fe2 = (FireEngine)car;
		fe2.water();
	}

}

class Car {
	String color;
	int door;
	
	void drive() {
		System.out.println("drive");
	}
	
	void stop() {
		System.out.println("stop");
	}
	
}

class FireEngine extends Car {
	void water() {
		System.out.println("water");
	}
}