import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_11057 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int[][] dp = new int[N + 1][10];
		for(int i = 0; i <= 9; i++) {
			dp[1][i] = 1;
		}
		
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j <= 9; j++) {
				if(j == 0) {
					dp[i][j] = 1;
					continue;
				}
				dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 10007;
			}
			
		}
		
		int answer = 0;
		for(int i = 0; i <= 9; i++) {
			answer += dp[N][i];
		}
		
		System.out.println(answer % 10007);
	}
	


}
