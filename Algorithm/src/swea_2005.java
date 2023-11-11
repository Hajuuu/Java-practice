import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class swea_2005 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringBuilder sb = new StringBuilder();
		for(int tc = 1; tc <= t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] dp = new int[n + 1][n + 1];
			dp[1][1] = 1;
			for(int i = 2; i <= n; i++) {
				for(int j = 1; j <= n; j++) {
					dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
				}
			}
			sb.append("#" + tc + "\n");
			for(int i = 1; i <= n; i++) {
				for(int j = 1; j <= i; j++) {
					sb.append(dp[i][j] + " ");
				}
				sb.append("\n");
			}
			
		}
		System.out.println(sb);
		
	}

}
