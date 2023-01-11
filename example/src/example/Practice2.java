package example;

class Tv {
	boolean power;
	int channel;
	
	void power() {	power = !power;	}
	void channelUp() {	++channel;	}
	void channelDown() {	--channel;	}
}

class CaptionTv extends Tv {
	boolean caption;
	void displayCaption(String text) {
		if(caption) {
			System.out.println(text);
		}
	}
}
public class Practice2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CaptionTv ctv = new CaptionTv();
		ctv.channel = 10;
		ctv.channelUp();
		System.out.println(ctv.channel);
		ctv.displayCaption("_World");
		ctv.caption = true;
		ctv.displayCaption("_World");
	}

}
