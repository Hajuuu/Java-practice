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
		
		int n = Integer.parseInt(br.readLine());
		
		dp = new Integer[1001];
		dp[1] = 1;
		dp[2] = 3;
		
		System.out.println(block(n));
	}
	
	static int block(int n) {
		
		if(dp[n] == null) {
			dp[n] = (block(n - 2) * 2 + block(n - 1)) % 10007;
		}
		return dp[n];
	}

} 
