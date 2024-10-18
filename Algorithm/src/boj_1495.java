import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1495 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int S = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N + 1];
		int[][] dp = new int[N + 1][2];
		st = new StringTokenizer(br.readLine());
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
	
		if(S + arr[1] > M) {
			dp[1][0] = -1;
		} else {
			dp[1][0] = S + arr[1];
		}
		
		if(S - arr[1] < 0) {
			dp[1][1] = -1;
		} else {
			dp[1][1] = S - arr[1];
		}
		if(dp[1][0] == -1 && dp[1][1] == -1) {
			System.out.println(-1);
			return;
		}
		for(int i = 2; i <= N; i++) {
			for(int j = 0; j < 2; j++) {
				int next1 = dp[i - 1][j] + arr[i];
				int next2 = dp[i - 1][j] - arr[i];
				if(next1 > M) {
					next1 = -1;
				}
				if(next2 < 0) {
					next2 = -1;
				}
				dp[i][j] = Math.max(next1, next2);
			}
			if(dp[i][0] == -1 && dp[i][1] == -1) {
				System.out.println(-1);
				return;
			}
			
		}
		
		System.out.println(Math.max(dp[N][0], dp[N][1]));
	}

}
