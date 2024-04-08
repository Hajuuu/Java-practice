import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1890 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		int[][] arr = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		long[][] dp = new long[N][N];

		dp[0][0] = 1;
		boolean check = true;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(dp[i][j] > 0) {
					if(i == N - 1 && j == N - 1) {
						check = false;
						break;
					}
					if(arr[i][j] == 0) {
						continue;
					}
					int nextX = i + arr[i][j];
					int nextY = j + arr[i][j];
					if(nextX >= 0 && nextX < N) {
						dp[nextX][j] += dp[i][j];
					}
					if(nextY >= 0 && nextY < N) {
						dp[i][nextY] += dp[i][j];
					}
					
				}
			}
			if(!check) {
				break;
			}
			
		}
		System.out.println(dp[N - 1][N - 1]);
	}

}
