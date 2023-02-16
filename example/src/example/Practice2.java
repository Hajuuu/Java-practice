package example;

import java.util.*;
import static java.util.Collections.*;

public class Practice2 {
	
	public static void main(String[] args) {
		//ArrayList list = new ArrayList(); //JDK1.5이전, 지네릭스 도입 이전
		//ArrayList<Object> list = new ArrayList<Object>(); //지네릭스 도입 이후
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(10);
		list.add(20);
		//list.add("30"); 컴파일 에러
		list.add(30);
		
		//Integer i = (Integer)list.get(2); //컴파일 ok, 형변환에러(실행시 발생 에러)
		Integer i = list.get(2); //형변환 생략 가능
		System.out.println(i);
	}
}
