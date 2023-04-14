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
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		
		int max = Math.max(a, b);
		int min = Math.min(a, b);
		int gcd = GCD(max, min);
		int lcm = a * b / gcd;
		System.out.println(gcd);
		System.out.println(lcm);
		
 	}
	
	public static int GCD(int a, int b) {
		if(b == 0)
			return a;
		else {
			return GCD(b, a % b);
		}
	}
	
	
} 
