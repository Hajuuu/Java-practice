import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_2294 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] arr = new int[n];
		long[] dp = new long[k + 1];
		
		for(int i = 0; i < n; i++) {
			arr[i] = Integer.parseInt(br.readLine());
			if(arr[i] <= k) {
				dp[arr[i]] = 1;
			}
			
		}
		
		for(int i = 0; i < k + 1; i++) {
			for(int j = 0; j < n; j++) {
				if(i - arr[j] > 0 && dp[i - arr[j]] > 0) {
					if(dp[i] != 0) {
						dp[i] = Math.min(dp[i], dp[i - arr[j]] + 1);
						continue;
					}
					dp[i] = dp[i - arr[j]] + 1;
				}
			}
		}
		
		if(dp[k] == 0) {
			System.out.println(-1);
			return;
		}
		System.out.println(dp[k]);
	}

}
