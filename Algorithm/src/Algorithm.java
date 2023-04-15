import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int fac = factorial(1, N);
		
		System.out.println(fac);
 	}
	
	public static int factorial(int a, int b) {
		if(b == 0) {
			return a;
		} else {
			return factorial(a * b, b - 1);
		}
	}
	
} 
