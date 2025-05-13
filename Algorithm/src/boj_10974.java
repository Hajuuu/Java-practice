import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    static int N;
    static int[] arr;
    static StringBuilder sb;
    static boolean[] visit;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N];
        sb = new StringBuilder();
        visit = new boolean[N + 1];
        backtracking(0);
        System.out.println(sb);

    }

    public static void backtracking(int depth) {
        if (depth == N) {
            for (int i : arr) {
                sb.append(i + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = 1; i <= N; i++) {
            if (visit[i]) {
                continue;
            }
            visit[i] = true;
            arr[depth] = i;
            backtracking(depth + 1);
            visit[i] = false;
        }
    }
}
