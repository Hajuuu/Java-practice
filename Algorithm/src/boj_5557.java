import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class boj_5557 {

	static long count;
	static int N;
	static int[] arr;
	static long[] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		arr = new int[N + 1];
		dp = new long[21];
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		dp[arr[1]] = 1;
		List<Number1> check = new ArrayList<>();
		for(int i = 2; i <= N - 1; i++) {
			for(int j = 0; j <= 20; j++) {
				if(dp[j] > 0) {
					check.add(new Number1(j, dp[j]));
				}
			}
			for(Number1 j : check) {
				if(j.idx - arr[i] < 0 && j.idx + arr[i] > 20) {
					continue;
				}
				dp[j.idx] = 0;
			}
			for(Number1 j : check) {
				if(j.idx - arr[i] >= 0) {
					dp[j.idx - arr[i]] += j.count;
				}
				if(j.idx + arr[i] <= 20) {
					dp[j.idx + arr[i]] += j.count;
				}
			}
			check = new ArrayList<>();
		}
		System.out.println(dp[arr[N]]);
		
	}

}


class Number1 {
	int idx;
	long count;
	
	Number1(int idx, long count) {
		this.idx = idx;
		this.count = count;
	}
}
