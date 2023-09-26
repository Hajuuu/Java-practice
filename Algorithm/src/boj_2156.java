import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_2156 {

	static int N;
	static int[] arr;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		arr = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}

		
		if(N == 1) {
			System.out.println(arr[1]);
			return;
		}
		
		int result = count();
		System.out.println(result);
	}
	
	public static int count() {
		int[] dp = new int[N + 1];
		dp[1] = arr[1];
		dp[2] = dp[1] + arr[2];
		for(int i = 3; i <= N; i++) {
			dp[i] = Math.max(dp[i - 2] + arr[i], Math.max(dp[i - 3] + arr[i - 1] + arr[i], dp[i - 1]));
		}
		return dp[N];
	}

}
