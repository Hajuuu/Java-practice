import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		// O(N^2)의 시간 복잡도
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		long n = Integer.parseInt(br.readLine());
		long i = n / 2;
		if(n % 2 == 0) {			
			System.out.println(n * (i - 1) + i);
		} else {
			System.out.println(n * i);
		}
		
		System.out.println(2);
		    
	}
}
