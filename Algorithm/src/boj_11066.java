import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class boj_11066 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            int K = Integer.parseInt(br.readLine());
            int[] file = new int[K + 1];
            int[] sum = new int[K + 1];
            int[][] dp = new int[K + 1][K + 1];

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= K; i++) {
                file[i] = Integer.parseInt(st.nextToken());
                sum[i] = sum[i - 1] + file[i];
            }

            for (int i = 1; i <= K; i++) {
                for (int j = 1; i + j <= K; j++) {
                    int q = i + j;
                    dp[j][q] = Integer.MAX_VALUE;
                    for (int k = j; k < q; k++) {
                        dp[j][q] = Math.min(dp[j][q], dp[j][k] + dp[k + 1][q] + sum[q] - sum[j - 1]);
                    }
                }
            }

            System.out.println(dp[1][K]);
        }

	}

}
