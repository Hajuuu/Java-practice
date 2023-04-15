import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int M = Integer.parseInt(st.nextToken());
		int N = Integer.parseInt(st.nextToken());
		
		boolean[] prime = prime(N);
		StringBuffer sb = new StringBuffer();
		for(int i = M; i <= N; i++) {
			if(prime[i] == false) {
				sb.append(i + "\n");
			}
		}
		
		System.out.println(sb);
		
 	}
	
	public static boolean[] prime(int N) {
		boolean[] prime = new boolean[N + 1];
		
		prime[0] = true;
		prime[1] = true;
		
		for(int i = 2; i <= Math.sqrt(N); i++) {
			if(prime[i] == true) {
				continue;
			}
			
			for(int j = i * i; j <= N; j += i) {
				prime[j] = true;
			}
			
		}
		
		return prime;
		
	}
	
	
} 
