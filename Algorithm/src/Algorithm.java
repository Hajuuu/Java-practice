import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			int max = Math.max(A, B);
			int min = Math.min(A, B);
			
			int gcd = GCD(max, min);
			int lcm = A * B / gcd;
			
			sb.append(lcm + "\n");
		}
		
		System.out.println(sb);
 	}
	
	public static int GCD(int a, int b) {
		if(b == 0) {
			return a;
		}
		else {
			return GCD(b, a % b);
		}
	}
	
	
} 
