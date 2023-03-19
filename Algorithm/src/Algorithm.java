import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Algorithm {
		
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int M = Integer.parseInt(br.readLine());
		int N = Integer.parseInt(br.readLine());
		
		int sum = 0;
		int min = 10001;
		for(int i = M; i <= N; i++) {
			if(prime(i)) {
				sum += i;
				if(min > i) {
					min = i;
				}
			}
				
		}
		
		if(sum == 0) {
			System.out.println(-1);
		} else {
			System.out.println(sum + "\n" + min);
		}
		

	}
	
	public static boolean prime(int a) {
		boolean isPrime = true;
		if(a == 1) {
			isPrime = false;
		}
			
		
		for(int i = 2; i <= Math.sqrt(a); i++) {
			if(a % i == 0) {
				isPrime = false;
			}
		}
		
		return isPrime;
	}
}
