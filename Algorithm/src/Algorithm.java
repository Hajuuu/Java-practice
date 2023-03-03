import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {
		
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		int len = str.length();
		int time = 0;
		for(int i = 0; i < len; i++) {
			int num = str.charAt(i) - 'A';
			if(num > 21)
				time += 10;
			else if(num > 18)
				time += 9;
			else if(num > 14)
				time += 8;
			else if(num > 11)
				time += 7;
			else if(num > 8)
				time += 6;
			else if(num > 5)
				time += 5;
			else if(num > 2)
				time += 4;
			else
				time += 3;
				
			
		}
		System.out.println(time);
	}
	
}
