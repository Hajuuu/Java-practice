import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] nodeList;
    static boolean[] visited;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());
        nodeList = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        for (int i = 1; i <= N; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            nodeList[u].add(v);
            nodeList[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(nodeList[i]);
        }

        dfs(V);
        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(V);
        System.out.println(sb);
    }


    public static void dfs(int start) {
        visited[start] = true;
        sb.append(start + " ");
        for (int i = 0; i < nodeList[start].size(); i++) {
            int now = nodeList[start].get(i);
            if (visited[now]) {
                continue;
            }
            dfs(now);
        }
    }

    public static void bfs(int start) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            sb.append(now + " ");
            for (int i = 0; i < nodeList[now].size(); i++) {
                int cur = nodeList[now].get(i);
                if (visited[cur]) {
                    continue;
                }
                visited[cur] = true;
                queue.offer(cur);
            }
        }
    }

}
