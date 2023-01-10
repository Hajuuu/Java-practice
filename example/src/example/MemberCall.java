package example;

public class MemberCall {
	int iv = 10;
	static int cv = 20;
	
	int iv2 = cv;
	//static int cv2 = iv;	//error. 클래스변수는 인스턴스변수를 사용할 수 없음.
	static int cv2 = new MemberCall().iv;	//객체를 생성하여 사용 가능
	
	static void staticMethod1() {
		System.out.println(cv);
		//Systen.out.println(iv);	//error. 클래스메서드에서 인스턴스변수 사용 불가.
		MemberCall c = new MemberCall();
		System.out.println(c.iv);
	}
	
	void instanceMethod1() {
		System.out.println(cv);
		System.out.println(iv);
	}
	
	static void staticMethod2() {
		staticMethod1();
		//instanceMethod();	//error. 클래스메서드에서는 인스턴스메서드 호출 불가.
		MemberCall c = new MemberCall();
		c.instanceMethod1();
	}
	
	void instanceMethod2() {
		staticMethod1();
		instanceMethod1();
	}
}
