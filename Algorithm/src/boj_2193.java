import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2193 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		long answer = pinary(N);
		
		System.out.println(answer);
	}

	public static long pinary(int N) {
		long[] dp = new long[N + 1];
		dp[1] = 1;
		for(int i = 2; i <= N; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}
		
		return dp[N];
	}
}
