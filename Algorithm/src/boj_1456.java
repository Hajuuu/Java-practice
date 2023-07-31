import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class boj_1456 {

	static boolean[] prime;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		long a = Long.parseLong(st.nextToken());
		long b = Long.parseLong(st.nextToken());
		
		prime = new boolean[10000001];
		isPrime();
		
		int count = 0;
		for(int i = 2; i < prime.length; i++) {
			if(!prime[i]) {
				long temp = i;
				while(i <= b / (double)temp) {
					if(i >= a / (double)temp) {
						count++;
					}
					temp = temp * i;
				}
			}
		}
		
		
		System.out.println(count);
	}
	
	public static void isPrime() {
		prime[0] = true;
		prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(prime.length); i++) {
			if(prime[i])
				continue;
			for(int j = i * i; j < prime.length; j += i) {
				prime[j] = true;
			}
		}
	}

}
