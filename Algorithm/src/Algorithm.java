import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		boolean[] prime = prime(1000000);
		
		int n = Integer.parseInt(br.readLine());
		while(n != 0) {		
			boolean gold = false;
			for(int i = 2; i <= n / 2; i++) {
				if(!prime[i] && !prime[n - i]) {
					System.out.println(n + " = " + i + " + " + (n - i));
					gold = true;
					break;
				}
			}
			
			if(!gold) {
				System.out.println("Goldbach's conjecture is wrong.");
			}
		
			n = Integer.parseInt(br.readLine());
		}
 	}
	
	public static boolean[] prime(int n) {
		boolean[] prime = new boolean[n + 1];
		
		prime[0] = true;
		prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(n); i++) {
			if(prime[i] == true) {
				continue;
			}
			
			for(int j = i * i; j <= n; j += i) {
				prime[j] = true;
			}
		}
		
		return prime;
	}
	
	
} 
