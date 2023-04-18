import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Stack;
import java.util.StringTokenizer;

public class Algorithm {
	
	static Integer[] dp;
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		int n = Integer.parseInt(br.readLine());
		
		dp = new Integer[1001];
		dp[1] = 1;
		dp[2] = 2;
		dp[3] = 4;
		
		for(int i = 0; i < n; i++) {
			int num = Integer.parseInt(br.readLine());
			sb.append(calc(num) + "\n");
		}
		
		System.out.println(sb);
	}
	
	static int calc(int n) {
		
		if(dp[n] == null) {
			dp[n] = calc(n - 3) + calc(n - 2) + calc(n - 1);
		}
		
		return dp[n];
	}


} 
