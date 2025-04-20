import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

    static ArrayList<Integer>[] nodeList;
    static int[] visited;
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        nodeList = new ArrayList[N + 1];
        visited = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            nodeList[u].add(v);
            nodeList[v].add(u);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(nodeList[i]);
        }

        bfs(R);

        for (int i = 1; i <= N; i++) {
            sb.append(visited[i]).append("\n");
        }

        System.out.println(sb);
    }

    public static void bfs(int R) {
        ArrayDeque<Integer> queue = new ArrayDeque<>();
        queue.offer(R);
        visited[R] = count;
        while (!queue.isEmpty()) {
            int now = queue.poll();
            for (int i : nodeList[now]) {
                if (visited[i] == 0) {
                    count++;
                    visited[i] = count;
                    queue.offer(i);
                }
            }
        }
    }

}
