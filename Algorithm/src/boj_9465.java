import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_9465 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine());
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine());
			int[][] dp = new int[n][3];
			int[][] arr = new int[2][n];
			
			for(int i = 0; i < 2; i++) {
				st = new StringTokenizer(br.readLine());
				for(int j = 0; j < n; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
				}
			}
			
			dp[0][0] = arr[0][0];
			dp[0][1] = arr[1][0];
			dp[0][2] = 0;
			
			for(int i = 1; i < n; i++) {
				for(int j = 0; j < 2; j++) {
					dp[i][j] = Math.max(dp[i - 1][(j + 1) % 2] + arr[j][i], dp[i - 1][2] + arr[j][i]);
				}
				dp[i][2] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][1], dp[i - 1][2]));
			}
			
			int answer = 0;
			for(int i = 0; i < 3; i++) {
				answer = Math.max(answer, dp[n - 1][i]);
			}
			
			sb.append(answer + "\n");
		}
		
		System.out.println(sb);
	}

}
