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
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int[] x = new int[N];
		st = new StringTokenizer(br.readLine());
		for(int i = 0; i < N; i++) {
			x[i] = Integer.parseInt(st.nextToken());
		}
		
		if(N == 1) {
			System.out.println(x[0] - S);
			return;
		}
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = Math.abs(S - x[i]);
		}
		
		int answer = arr[0];
		for(int i = 1; i < N; i++) {
			answer = GCD(answer, arr[i]);
		}
		
		System.out.println(answer);
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
