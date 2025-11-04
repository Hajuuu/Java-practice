import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        for (int tc = 1; tc <= 10; tc++) {
            int N = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            int[] buildings = new int[N];
            for (int i = 0; i < N; i++) {
                buildings[i] = Integer.parseInt(st.nextToken());
            }
            int sum = 0;
            for (int i = 2; i < N - 2; i++) {
                int max = Integer.MIN_VALUE;
                if (buildings[i] < buildings[i + 1] || buildings[i] < buildings[i - 1]) {
                    continue;
                }
                if (buildings[i] < buildings[i + 2] || buildings[i] < buildings[i - 2]) {
                    continue;
                }
                max = Math.max(max, Math.max(buildings[i - 1], Math.max(buildings[i - 2], Math.max(buildings[i + 1], buildings[i + 2]))));
                sum += buildings[i] - max;
            }
            sb.append("#" + tc + " " + sum + "\n");
        }
        System.out.println(sb);
    }

}
