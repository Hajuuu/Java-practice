import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_10844 {

	static int[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		dp = new int[N + 1][10];
		count(N);
		
		long answer = 0;
		for(int i = 0; i <= 9; i++) {
			answer += dp[N][i];
		}
		answer %= 1000000000;
		System.out.println(answer);
		
	}
	
	public static void count(int N) {
		dp[1][0] = 0;
		for(int i = 1; i < 10; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < 10; j++) {
				if(j == 0) {
					dp[i][j] = dp[i - 1][j + 1];
				}
				else if(j == 9) {
					dp[i][j] = dp[i - 1][j - 1];
				}
				else { 
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % 1000000000;
				}
				
			}
		}
		
	}

}
