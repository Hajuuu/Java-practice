import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.StringTokenizer;

public class boj_1010 {

	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		StringTokenizer st;
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			BigDecimal answer = combination(N, M);
			sb.append(answer + "\n");
		}
		
		System.out.println(sb);
		
		
		
	}
	
	public static BigDecimal combination(int N, int M) {
		double[] dp = new double[M + 1];
		dp[1] = 1;
		int num = Math.max(N, M - N);
		for(int i = 2; i <= num; i++) {
			dp[i] = 1;
		}
		int j = M - num;
		for(int i = num + 1; i <= M; i++) {
			dp[i] = dp[i - 1] * ((double) i / j);
			j--;
			
		}
		return new BigDecimal(Math.round(dp[M]));
	}

}
