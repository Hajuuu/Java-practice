import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    /**
     * 최장 증가 부분 수열 -> dp 문제
     * 이중 for문으로 현재 arr보다 이전 arr이 작으면 dp값 갱신
     * dp[i] = Math.max(dp[i], dp[j] + 1);
     */
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[N];
            int[] dp = new int[N];
            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < N; i++) {
                dp[i] = 1;
                for (int j = 0; j < i; j++) {
                    if (arr[i] > arr[j]) {
                        dp[i] = Math.max(dp[i], dp[j] + 1);
                    }
                }
            }
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < N; i++) {
                max = Math.max(max, dp[i]);
            }
            sb.append("#" + tc + " " + max + "\n");
        }
        System.out.println(sb);
    }

}
