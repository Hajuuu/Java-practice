import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {


    static int[] nodes;
    static boolean[] visited;
    static boolean[] done;
    static int count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int tc = 0; tc < T; tc++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            nodes = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                nodes[i] = Integer.parseInt(st.nextToken());
            }
            visited = new boolean[n + 1];
            done = new boolean[n + 1];
            count = 0;
            for (int i = 1; i <= n; i++) {
                if (done[i]) {
                    continue;
                }
                dfs(i);
            }
            sb.append(n - count + "\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int start) {
        if (done[start]) {
            return;
        }
        if (visited[start]) {
            done[start] = true;
            count++;
        }
        visited[start] = true;
        dfs(nodes[start]);
        visited[start] = false;
        done[start] = true;
    }

}
