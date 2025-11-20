import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static int[][] arr;
    static int N, L;
    static int answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int TC = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= TC; tc++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
            arr = new int[N][2];
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                arr[i][0] = Integer.parseInt(st.nextToken());
                arr[i][1] = Integer.parseInt(st.nextToken());
            }
            answer = 0;
            dfs(0, 0, 0);
            sb.append("#" + tc + " " + answer + "\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int score, int kcal, int depth) {
        if (kcal >= L) {
            return;
        }
        answer = Math.max(answer, score);
        for (int i = depth; i < N; i++) {
            dfs(score + arr[i][0], kcal + arr[i][1], i + 1);
        }
    }

}
