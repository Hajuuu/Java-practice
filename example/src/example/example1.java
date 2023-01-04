package example;
import java.util.*;

public class example1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 5, j = 0;
		
		j = i++;
		System.out.println("j=i++; 실행후, i="+i+", j="+j);
		
		i = 5;
		j = 0;
		
		j = ++i;
		System.out.println("j=++i; 실행후, i="+i+", j="+j);
		

	}

}
