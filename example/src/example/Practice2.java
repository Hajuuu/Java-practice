package example;

import java.util.*;

public class Practice2 {
	
	public static void main(String[] args) {
		//ArrayList list = new ArrayList();
		//TreeSet c = new TreeSet(); //set은 Collection의 자손
		Collection c = new TreeSet(); //유연한 코드 작성 가능
		c.add("1");
		c.add("2");
		c.add("3");
		c.add("4");
		c.add("5");
		
		Iterator it = c.iterator();
		
		while(it.hasNext()) {
			Object obj = it.next();
			System.out.println(obj);
		}
		
	}
}

