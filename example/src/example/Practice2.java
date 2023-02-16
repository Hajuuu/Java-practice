package example;

import java.util.*;
import static java.util.Collections.*;

class Tv {}
class Audio {}
public class Practice2 {
	
	public static void main(String[] args) {
		ArrayList<Tv> list = new ArrayList<Tv>(); //참조 변수에 대입된 타입과 생성자에 대입된 타입이 같아야함
		list.add(new Tv());
		//list.add(new Audio());
	}
}
