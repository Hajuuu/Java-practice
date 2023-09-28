import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_1912 {

	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int[] arr = new int[N + 1];
		for(int i = 1; i <= N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int answer = count(arr, N);
		
		System.out.println(answer);
	}
	
	public static int count(int[] arr, int N) {
		int[] dp = new int[N + 1];
		int answer = Integer.MIN_VALUE;
		for(int i = 1; i <= N; i++) {
			dp[i] = Math.max(dp[i - 1] + arr[i], arr[i]);
			answer = Math.max(dp[i], answer);
		}
		return answer;
	}

}
