import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static boolean[][] visited;
    static int[] dx = {1, 1, 2, 2, -1, -1, -2, -2};
    static int[] dy = {2, -2, 1, -1, 2, -2, 1, -1};
    static int l;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < T; i++) {
            l = Integer.parseInt(br.readLine());
            visited = new boolean[l][l];
            st = new StringTokenizer(br.readLine());
            int startX = Integer.parseInt(st.nextToken());
            int startY = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            int endX = Integer.parseInt(st.nextToken());
            int endY = Integer.parseInt(st.nextToken());
            int count = BFS(startX, startY, endX, endY);
            sb.append(count + "\n");
        }

        System.out.println(sb);
    }

    public static int BFS(int startX, int startY, int endX, int endY) {
        Deque<int[]> queue = new ArrayDeque<>();
        visited[startX][startY] = true;
        queue.offer(new int[]{startX, startY, 0});
        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            if (now[0] == endX && now[1] == endY) {
                return now[2];
            }
            for (int i = 0; i < 8; i++) {
                int x = now[0] + dx[i];
                int y = now[1] + dy[i];
                if (x >= 0 && y >= 0 && x < l && y < l) {
                    if (!visited[x][y]) {
                        visited[x][y] = true;
                        queue.offer(new int[]{x, y, now[2] + 1});
                    }
                }
            }
        }
        return 0;
    }

}

