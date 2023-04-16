import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Algorithm {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuffer sb = new StringBuffer();
		StringTokenizer st;
		for(int i = 0; i < t; i++) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int[] arr = new int[n];
			for(int j = 0; j < n; j++) {
				arr[j] = Integer.parseInt(st.nextToken());
			}
			long sum = 0;
			for(int k = 0; k < n; k++) {
				for(int q = k + 1; q < n; q++) {
					sum += GCD(arr[k], arr[q]);
				}			
			}
			
			sb.append(sum + "\n");
		}
		
		System.out.println(sb);
	}
	
	public static int GCD(int a, int b) {
		if(b == 0) {
			return a;
		} else {
			return GCD(b, a % b);
		}
	}
} 
